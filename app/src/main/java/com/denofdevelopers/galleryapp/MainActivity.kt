package com.denofdevelopers.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denofdevelopers.galeryapp.R
import com.denofdevelopers.galleryapp.ui.theme.GaleryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleryAppTheme {
                GalleryApp()
            }
        }
    }
}

@Composable
private fun GalleryApp(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.rick
    val secondArtwork = R.drawable.morty
    val thirdArtwork = R.drawable.summer
    val fourthArtwork = R.drawable.beth
    val fifthArtwork = R.drawable.jerry

    var title by remember { mutableStateOf(R.string.rick) }
    var year by remember { mutableStateOf(R.string.rick_year) }
    var currentArtwork by remember { mutableStateOf(firstArtwork) }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkImage(currentArtworkId = currentArtwork)
        Spacer(modifier = Modifier.height(32.dp))
        ArtworkTitle(titleId = title, yearId = year)
        Spacer(modifier = Modifier.height(32.dp))
        //Previous button
        Row(
            modifier = Modifier.padding(
                horizontal = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.jerry
                            year = R.string.jerry_year
                        }

                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.rick
                            year = R.string.rick_year
                        }

                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.morty
                            year = R.string.morty_year
                        }

                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.summer
                            year = R.string.summer_year
                        }

                        else -> {
                            currentArtwork = fourthArtwork
                            title = R.string.beth
                            year = R.string.beth_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_previous)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            //Next button
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.morty
                            year = R.string.morty_year
                        }

                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.summer
                            year = R.string.summer_year
                        }

                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.beth
                            year = R.string.beth_year
                        }

                        fourthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.jerry
                            year = R.string.jerry_year
                        }

                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.rick
                            year = R.string.rick_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_next)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
private fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtworkId: Int
) {
    Image(
        painter = painterResource(currentArtworkId),
        contentDescription = stringResource(R.string.rick),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun ArtworkTitle(
    @StringRes titleId: Int,
    @StringRes yearId: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(titleId),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_500),
            fontSize = 32.sp
        )
        Text(
            text = stringResource(yearId),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_200),
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaleryAppTheme {
        GalleryApp()
    }
}