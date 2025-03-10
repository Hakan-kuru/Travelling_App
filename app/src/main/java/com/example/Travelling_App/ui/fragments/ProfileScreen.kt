package com.example.Travelling_App.ui.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(userName: String, email: String, budget: Double, preference: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Filled.Person, contentDescription = "Profile Icon", modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text("Kullanıcı Adı: $userName", style = MaterialTheme.typography.headlineSmall)
        Text("Email: $email", style = MaterialTheme.typography.bodySmall)
        Text("Bütçe: $budget", style = MaterialTheme.typography.bodySmall)
        Text("Tercihler: $preference", style = MaterialTheme.typography.bodySmall)
    }
}