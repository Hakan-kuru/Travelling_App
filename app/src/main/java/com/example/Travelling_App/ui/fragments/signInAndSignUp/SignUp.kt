package com.example.app.signup

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.Travelling_App.presentation.viewmodel.UserViewModel

@Composable
fun SignUp(
    onSignUpSuccess: (String) -> Unit,
    onSignUpError: (String) -> Unit,
    viewModel: UserViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var budget by remember { mutableStateOf("") }
    var preferences by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Kayıt Ol", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        // Username Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Kullanıcı Adı") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Budget Field
        OutlinedTextField(
            value = budget,
            onValueChange = { budget = it },
            label = { Text("Bütçe (Opsiyonel)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Preferences Field
        OutlinedTextField(
            value = preferences,
            onValueChange = { preferences = it },
            label = { Text("Tercihler (Opsiyonel)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Şifre") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password Field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Şifreyi Doğrula") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Button
        Button(
            onClick = {
                loading = true
                if (password != confirmPassword) {
                    onSignUpError("Şifreler eşleşmiyor.")
                    loading = false
                    return@Button
                }

                val result = viewModel.signUp(
                    username = username,
                    email = email,
                    password = password,
                    budget = budget.toDoubleOrNull(),
                    preferences = preferences,
                    onResult = { success ->
                        if (success) {
                            onSignUpSuccess("Kayıt başarılı!")
                        } else {
                            onSignUpError("Bir hata oluştu.")
                        }
                    }
                )
                loading = false

            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !loading
        ) {
            Text("Kayıt Ol")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpPreview() { // Eğer bir mock veya sahte viewModel gerekirse
    SignUp(
        onSignUpSuccess = { message -> println("Success: $message") },
        onSignUpError = { error -> println("Error: $error") },
        viewModel = hiltViewModel()
    )
}


