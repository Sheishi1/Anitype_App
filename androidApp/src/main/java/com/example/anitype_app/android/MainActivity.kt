package com.example.anitype_app.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Column {
        TrailerPreview()
    }
}

@Composable
fun trailer(image: String, modifier: Modifier) {
    Surface(
        modifier
            .height(400.dp),

        ) {
        Box(modifier = modifier) {

            Image(
                painter = painterResource(id = R.drawable.zerotwo),
                contentDescription = "trailers of aby anime",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .heightIn(300.dp, 500.dp)
            )
            Surface(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(80.dp, 100.dp)
                    .background(Color.Black)
                    .align(Alignment.BottomCenter)
            ) {
                Surface(
                    color = Color.Transparent,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Любимый во франксе",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W700,
                            fontFamily = FontFamily(Font(R.font.rubik)),
                            fontSize = 24.sp,
                        )

                        Row(

                        ) {
                            Text(
                                modifier = Modifier.padding(end = 8.dp),
                                text = "9.99",
                                color = Color.Green,
                                fontWeight = FontWeight.W400,
                                fontFamily = FontFamily(Font(R.font.rubik)),
                                fontSize = 10.sp,
                            )

                            Text(
                                modifier = Modifier.padding(end = 8.dp),
                                text = "24 эпизода",
                                color = Color.White,
                                fontWeight = FontWeight.W400,
                                fontFamily = FontFamily(Font(R.font.rubik)),
                                fontSize = 10.sp,
                            )

                            Text(
                                modifier = Modifier.padding(end = 8.dp),
                                text = "Драма, Меха, Романтика",
                                color = Color.White,
                                fontWeight = FontWeight.W400,
                                fontFamily = FontFamily(Font(R.font.rubik)),
                                fontSize = 10.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrailerPreview() {
    MyApplicationTheme {
        trailer("zxc", Modifier)
    }
}
