package com.example.Travelling_App.ui.fragments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class HomeFragment{
    @Composable
    fun HomeScreen(
        onNavigationProfile: () -> Unit,
        onNavigationDetails: (String) -> Unit
    ) {
        Scaffold(
            topBar = { AppTopBar() }, // Açılır menü barı
            floatingActionButton = { ChatbotButton() } // Chatbot butonu
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SearchBar()
                Spacer(modifier = Modifier.height(16.dp))
                RecommendationSection(
                    title = "Popüler Restoranlar",
                    items = listOf("Restoran 1", "Restoran 2", "Restoran 3"),
                    onItemClick = { onNavigationDetails(it) }
                )
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppTopBar() {
        TopAppBar(
            title = { Text("Travel App") },
            navigationIcon = {
                IconButton(onClick = { /* Menü açılır */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        )
    }
    @Composable
    fun SearchBar() {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            placeholder = { Text("Ara...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        )
    }
    @Composable
    fun RecommendationSection(
        title: String,
        items: List<String>,
        onItemClick: (String) -> Unit
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(items) { item ->
                    RecommendationCard(item, onItemClick)
                }
            }
        }
    }

    @Composable
    fun RecommendationCard(
        name: String,
        onClick: (String) -> Unit
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .size(150.dp)
                .clickable { onClick(name) },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = name)
            }
        }
    }
    @Composable
    fun ChatbotButton() {
        FloatingActionButton(onClick = { /* Chatbot ekranına yönlendir */ }) {
            Icon(Icons.Default.Chat, contentDescription = "Chatbot")
        }
    }



}