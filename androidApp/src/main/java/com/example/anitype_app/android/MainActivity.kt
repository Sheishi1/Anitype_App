package com.example.anitype_app.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anitype_app.Trailer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    MyApp(Modifier)
                }
            }
        }
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun MyApp(modifier: Modifier) {
    LazyColumn {
        item {
            TrailerPreview()
            ListsPreview()
        }
    }
}

@Composable
fun trailer(image: String, title: String, rate: String, series: String, genres: String, modifier: Modifier) {
    BoxWithConstraints(
        modifier.height(400.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = painterResource(id = R.drawable.zerotwo),
            contentDescription = "trailers of any anime",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .heightIn(300.dp, 500.dp)
        )
        // Затемнение снизу trailer
        Canvas(modifier = modifier.fillMaxSize(),
            onDraw = { drawRect(Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
            })
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Surface(
                color = Color.Transparent,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontSize = 24.sp,
                    )

                    Row(

                    ) {
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = rate,
                        color = Color.Green,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontSize = 10.sp,
                    )

                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = series,
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontSize = 10.sp,
                    )

                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = genres,
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily(Font(R.font.rubik)),
                        fontSize = 10.sp,
                    )
                }
                }
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            ) {
                Text(
                    text = "Смотреть",
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun lists(name: String, modifier: Modifier) {
    BoxWithConstraints(
        modifier
            .fillMaxSize()
            .padding(30.dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(topStart = 8.dp, topEnd = 10.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                text = "Продолжить просмотр",
                color = Color.White,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontSize = 16.sp,
            )
            LazyRow (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10) { listItem(name = name, modifier = modifier) }
            }

            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                text = "Новинки",
                color = Color.White,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontSize = 16.sp,
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10) { listItem(name = name, modifier = modifier) }
            }
        }
    }
}

@Composable
fun listItem (name: String, modifier: Modifier) {
    Surface (
        modifier
            .height(200.dp)
            .width(250.dp)
            .padding(end = 10.dp),
        color = Color.Transparent,
        ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.zerotwo),
                contentDescription = "listItem",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(150.dp)
                    .width(250.dp)
            )

            Text(
                text = name,
                color = Color.White,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(Font(R.font.rubik)),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrailerPreview() {
    MyApplicationTheme {
        trailer(image = "any",
            title = "Милый во франксе",
            rate = "9.99",
            series = "24 эпизода",
            genres = "Драма, Меха, Романтика",
            Modifier)
    }
}

@Preview
@Composable
fun ListsPreview() {
    MyApplicationTheme {
        lists(name = "Милый во франксе", modifier = Modifier)
    }
}
@Preview
@Composable
fun ListItemPreview() {
    MyApplicationTheme {
        listItem(name = "Милый во франксе", modifier = Modifier)
    }
}