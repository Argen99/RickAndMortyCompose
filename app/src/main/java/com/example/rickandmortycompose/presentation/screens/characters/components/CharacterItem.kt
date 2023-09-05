package com.example.rickandmortycompose.presentation.screens.characters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.model.CharacterModel
import com.example.rickandmortycompose.ui.theme.Gray
import com.example.rickandmortycompose.ui.theme.Green
import com.example.rickandmortycompose.ui.theme.Red

@Composable
fun CharacterItem(
    item: CharacterModel
) {
    val color = when (item.status.lowercase()) {
        "alive" -> Green
        "dead" -> Red
        else -> Gray
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(80.dp),
                model = item.image,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .height(80.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                )
                Text(
                    text = item.species,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .size(12.dp)
                                .clip(RoundedCornerShape(100))
                                .background(color = color)
                        )
                        Text(
                            text = item.status,
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    IconButton(
                        modifier = Modifier.size(20.dp),
                        onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}