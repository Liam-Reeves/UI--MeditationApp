@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.plcoding.meditationuiyoutube.ui






import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.meditationuiyoutube.Feature
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.ui.theme.LightRed
import com.plcoding.meditationuiyoutube.ui.theme.TextWhite


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            Greeting_Section()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia","Depression"))
            CurrentMeditation()

        }

    }
}

@Composable
fun Greeting_Section(
    name: String = "Liam"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Column {
            Text(
                text ="Good morning $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text ="We wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}
@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember{
        mutableStateOf(0)

    }
    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it

                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = chips[it],
                    color = TextWhite,)

            }
        }
    }

}
@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text ="Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text ="Meditation . 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite,
            )

        }
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id =R.drawable.ic_play ),
                contentDescription ="Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp))

        }

    }

}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature> ){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
            
            )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier =Modifier.fillMaxHeight()
        ) {
            items(features.size){

            }

        }
        
    }
    

}
@Composable
fun featureItem(
    feature :  Feature
){
        BoxWithConstraints(
            modifier = Modifier
                .padding(7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(feature.darkColor)
        ) {
            val width =constraints.maxWidth
            val height = constraints.maxHeight

            //medium colored path
            val mediumColoredPoint1 = Offset(x = 0f, height * 0.3f)
            val mediumColoredPoint2 = Offset(width *0.1f, height * 0.35f)
            val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
            val mediumColoredPoint4 = Offset(width *0.75f, height * 0.7f)
            val mediumColoredPoint5 = Offset(width *1.4f, -height.toFloat())

            val mediumColoredPath = androidx.compose.ui.graphics.Path().apply{
                moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
                quadraticBezierTo(
                    mediumColoredPoint2.x,
                    mediumColoredPoint2.y,

                    (mediumColoredPoint1.x + mediumColoredPoint2.x) / 2f,
                    (mediumColoredPoint1.y + mediumColoredPoint2.y) / 2f


                )
            }
        }


}



















@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    HomeScreen()
}














