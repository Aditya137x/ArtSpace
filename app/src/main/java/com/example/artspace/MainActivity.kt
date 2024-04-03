package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtImage()
                }
            }
        }
    }
}

@Composable
fun ArtImage() {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(40.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        var result by remember { mutableIntStateOf( 1) }
        val imageResource = when(result) {
            1 -> R.drawable.sunday
            2 -> R.drawable.aday
            3 -> R.drawable.market
            4 -> R.drawable.book
            5 -> R.drawable.cafe
            else -> R.drawable.draw
        }

        val textResource = when(result) {
            1 -> R.string.sunday
            else -> R.string.day
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                //.size(width = 240.dp, height = 100.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .border(10.dp, MaterialTheme.colorScheme.primaryContainer)
                    .align(Alignment.CenterHorizontally)
                    .shadow(10.dp),
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp),
            colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.secondaryContainer)

        ) {
            Text(
                text = stringResource(textResource),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier= Modifier.padding(15.dp,15.dp,10.dp,5.dp)
            )
            Text(
                text = "by Dhanashri Kundargi",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier= Modifier.padding(15.dp,5.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (result==1) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { result++ }) {
                    Text(text = "Next", modifier = Modifier.padding(horizontal = 13.dp))

                }
            }
        }
        else if (result==6) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { result-- }) {
                    Text(text = "Previous")

                }
            }
        }
        else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { result-- }) {
                    Text(text = "Previous")

                }

                Button(onClick = { result++ }) {
                    Text(text = "Next", modifier = Modifier.padding(horizontal = 13.dp))

                }
            }
        }



    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtImage()
    }
}