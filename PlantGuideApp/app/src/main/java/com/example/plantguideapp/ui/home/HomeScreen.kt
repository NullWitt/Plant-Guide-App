package com.example.plantguideapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantguideapp.R

private val LightGreen = Color(0xFFA8E6A3)
private val MidGreen = Color(0xFF66CC66)
private val DarkGreen = Color(0xFF339933)

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit,
    onFavoritesClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(MidGreen, LightGreen)
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Справочник",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Баннер
            Image(
                painter = painterResource(id = R.drawable.banner_placeholder),
                contentDescription = "Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Кнопка Избранное
            Button(
                onClick = onFavoritesClick,
                colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Избранное",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Категории
            Text(
                text = "Категории",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            CategoryCard("Овощи", R.drawable.icon_vegetables) {
                onCategoryClick("Овощи")
            }

            Spacer(modifier = Modifier.height(12.dp))

            CategoryCard("Травы", R.drawable.icon_herbs) {
                onCategoryClick("Травы")
            }

            Spacer(modifier = Modifier.height(12.dp))

            CategoryCard("Комнатные растения", R.drawable.icon_indoor) {
                onCategoryClick("Комнатные растения")
            }
        }
    }
}

@Composable
fun CategoryCard(name: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
