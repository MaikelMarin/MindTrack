package com.vipermech.mindtrack.presentation.ui.screens.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.vipermech.mindtrack.presentation.viewmodel.auth.LoginViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.vipermech.mindtrack.R
import com.vipermech.mindtrack.presentation.ui.measures.paddingDefault
import com.vipermech.mindtrack.presentation.ui.measures.spaceComponentsMedium
import com.vipermech.mindtrack.presentation.ui.measures.spaceComponentsSmall
import com.vipermech.mindtrack.presentation.ui.nameApp

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val user by viewModel.user.collectAsState()

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(user) {
        if (uiState.user != null) {
            onLoginSuccess()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image( painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = nameApp)
        Spacer(modifier = Modifier.height(spaceComponentsMedium))
        Text(color = MaterialTheme.colorScheme.onBackground, text = "Iniciar sesión", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(spaceComponentsMedium))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it.trim() },
            label = { Text("Correo electrónico") }
        )
        Spacer(modifier = Modifier.height(spaceComponentsSmall))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it.trim() },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(spaceComponentsMedium))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(start = paddingDefault, end = paddingDefault)
        ) {

            TextButton( onClick = { viewModel.register(email, password) }) {
                Text("Registrarse")
            }

            Button(onClick = { viewModel.login(email, password) }) {
                Text(color = MaterialTheme.colorScheme.onPrimary, text = "Iniciar sesión")
            }

        }


        Spacer(modifier = Modifier.height(spaceComponentsMedium))


        TextButton(onClick = { viewModel.forgotPassword(email) }) {
            Text(color = MaterialTheme.colorScheme.onSurface, text = "¿Olvidaste tu contraseña?")
        }

        Spacer(modifier = Modifier.height(spaceComponentsMedium))

        if (uiState.isLoading) {
            CircularProgressIndicator()
            Toast.makeText(
                LocalContext.current,
                "Loading...",
                Toast.LENGTH_SHORT).show()
        }

        if (uiState.user != null) {
            Toast.makeText(
                LocalContext.current,
                "Authentication successful.",
                Toast.LENGTH_SHORT).show()
        }

        uiState.error?.let {
            Text(text = it, color = Color.Red)
            Toast.makeText(
                LocalContext.current,
                "Authentication failed.",
                Toast.LENGTH_SHORT).show()
        }
    }
}
