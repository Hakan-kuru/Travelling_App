// ReminderScreen.kt
package com.example.Travelling_App.ui.fragments.Details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.Travelling_App.domain.models.Reminder
import com.example.Travelling_App.presentation.viewmodel.ReminderViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun ReminderScreen(viewModel: ReminderViewModel = viewModel()) {
    val plannedReminders by viewModel.plannedReminders.collectAsState()
    val wishListReminders by viewModel.wishListReminders.collectAsState()

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            listOf("Planlanmış", "İstek Listesi").forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.scrollToPage(index) }
                    }
                )
            }
        }

        HorizontalPager(count = 2, state = pagerState) { page ->
            when (page) {
                0 -> ReminderList(reminders = plannedReminders)
                1 -> ReminderList(reminders = wishListReminders)
            }
        }
    }
}

@Composable
fun ReminderList(reminders: List<Reminder>) {
    if (reminders.isEmpty()) {
        Text(
            text = "Gösterilecek hatırlatıcı yok.",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    } else {
        LazyColumn {
            items(reminders, key = { it.reminderId }) { reminder ->
                ReminderCard(reminder = reminder)
            }
        }
    }
}

@Composable
fun ReminderCard(reminder: Reminder) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            reminder.reminderDate?.let {
                Text(
                    text = "Tarih: $it",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = reminder.reminderNote,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}