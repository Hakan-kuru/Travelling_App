import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(userName: String, restaurants: List<Restaurant>, touristPlaces: List<Destination>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ana Sayfa") },
                navigationIcon = {
                    IconButton(onClick = { /* Hamburger Menü Aç */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Profil Sayfasına Git */ }) {
                        Icon(Icons.Filled.Person, contentDescription = "Profile")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search Bar
            OutlinedTextField(
                value = "",
                onValueChange = { /* Arama fonksiyonu */ },
                placeholder = { Text("Ara...") },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(LineHeightStyle.Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Popüler Restoranlar
            Text("Popüler Restoranlar", style = MaterialTheme.typography.h6)
            HorizontalCardList(restaurants.map { it.restaurantName })

            Spacer(modifier = Modifier.height(16.dp))

            // Turistik Mekanlar
            Text("Turistik Mekanlar", style = MaterialTheme.typography.h6)
            HorizontalCardList(touristPlaces.map { it.name })

            Spacer(modifier = Modifier.height(16.dp))

            // Daha Fazla Butonu
            Button(onClick = { /* Daha Fazla Görüntüle */ }) {
                Text("Daha Fazla")
            }
        }
    }
}

@Composable
fun HorizontalCardList(items: List<String>) {
    LazyRow {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp, 100.dp),
                elevation = 4.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = item, style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}
