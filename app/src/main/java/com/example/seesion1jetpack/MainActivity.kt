package com.example.seesion1jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seesion1jetpack.ui.theme.Seesion1JetpackTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Seesion1JetpackTheme {
                Scaffold(
                    topBar = {
                        TopAppBar()
                    }
                ) {
                    LazyColumn(){
                        item {
                            LazyRow(){
                                MountainCards()
                            }
                            Row(
                                modifier = Modifier.padding(8.dp)
                                    .fillMaxWidth(),
                                  horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Text(
                                    text = "Best Destination",
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    text = "View All",
                                    color = Color.Blue
                                )

                            }
                            LazyRow(){
                                DestinationCards()
                            }
                            LazyRow(){
                                DestinationCards()
                            }
                            LazyRow(){
                                DestinationCards()
                            }
                            LazyRow(){
                                DestinationCards()
                            }
                            LazyRow(){
                                DestinationCards()
                            }
                        }
                }




                }
            }
        }
    }

}



@Composable
fun TopAppBar() {

    TopAppBar(
        elevation = 0.dp,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    painter = painterResource(id = R.drawable.img2),

                    contentDescription = null,


                    )

                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.White

                )

            }
        }
    )
}



private fun LazyListScope.MountainCards(){

    items(mountains){
        mountain ->
        Card(

            modifier = Modifier
                .padding(8.dp)
                .wrapContentHeight()
                .wrapContentWidth()
                .clip(shape = RoundedCornerShape(15.dp))


        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(.4f)

//                        .padding(horizontal = 0.dp, vertical = 35.dp)
                    .height(180.dp)
                    .width(200.dp)

                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.Yellow),
                contentAlignment = Alignment.BottomCenter


            ) {
                Image(
                    painter = painterResource(mountain.image),
                    contentDescription = null, contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .padding(8.dp),


                    ) {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Bottom),
                                text = mountain.name,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = mountain.icon,
                                    contentDescription = null,
                                    tint = Color.Yellow,
                                    modifier = Modifier.size(18.dp)
                                )

                                Text(
                                    modifier = Modifier.align(Alignment.Bottom),
                                    text = mountain.rating.toString(),
                                    color = Color.White

                                )
                            }


                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),

                            ) {

                            Icon(
                                imageVector = mountain.icon2,
                                contentDescription = null,
                                tint = Color.White
                            )

                            Text(

                                text = mountain.location,
                                color = Color.White
                            )


                        }
                    }
                }
            }

        }
    }
}

private fun LazyListScope.DestinationCards(){
    items(destinations){
        destination ->
        Card(

            modifier = Modifier
                .padding(8.dp)
                .width(200.dp),


                shape = RoundedCornerShape(15.dp)

        ) {

            Column() {
                Image(
                    painter = painterResource(destination.image),
                    contentDescription = null
                )
                Column(

                ) {


                    Row(
                        modifier =Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = destination.name)
                        Row(
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                modifier = Modifier.size(19.dp),
                                imageVector = destination.icon,
                                tint = Color.Red,
                                contentDescription = null
                            )
                            Text(text = destination.rating.toString())
                        }
                    }
                    Row {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            imageVector = destination.icon2,
                            contentDescription = null
                        )
                        Text(
                            text = destination.location,
                            fontWeight = FontWeight.ExtraLight
                        )

                    }


                }
            }

        }
    }
}




data class Mountain(
    val icon: ImageVector,
    val icon2: ImageVector,
    val image: Int,
    val name: String,
    val location: String,
    val rating: Float

)

val mountains = listOf(
    Mountain(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.m1,
        name = "Northern Mountain",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    ),
    Mountain(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.img_1,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    ),
    Mountain(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.img_1,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    ),
    Mountain(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.img_2,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    ),
    Mountain(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.img_2,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    )
)


data class Destination(
    val icon: ImageVector,
    val icon2: ImageVector,
    val image: Int,
    val name: String,
    val location: String,
    val rating: Float
)

val destinations = listOf(
    Destination(
        icon = Icons.Default.Star,
        icon2 = Icons.Default.LocationOn,
        image = R.drawable.m1,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.9f
    ),
    Destination(
        icon2 = Icons.Default.LocationOn,
        icon = Icons.Default.Star,
        image = R.drawable.img_2,
        name = "Darma Reservoir",
        location = "Darma, Sunamgnj",
        rating = 4.9f
    ),
    Destination(
        icon2 = Icons.Default.LocationOn,
        icon = Icons.Default.Star,
        image = R.drawable.img_1,
        name = "Darma Reservoir",
        location = "Darma, Sunamgnj",
        rating = 4.9f
    ),
    Destination(
        icon2 = Icons.Default.LocationOn,
        icon = Icons.Default.Star,
        image = R.drawable.img_2,
        name = "Darma Reservoir",
        location = "Darma, Sunamgnj",
        rating = 4.9f
    )
)


