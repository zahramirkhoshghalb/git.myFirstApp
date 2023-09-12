package com.example.myfirstapp

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.parseConstraintSets

@Composable
fun Profilepage() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 50.dp, bottom = 100.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))

    ) {
        BoxWithConstraints() {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(margin = 16.dp)
            } else {
                landscapeConstraints(margin = 16.dp)

            }


            ConstraintLayout(constraints)
            {

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "pamerian",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Magenta,
                            shape = CircleShape
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Red Sable Pomeranian", fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("nameText")


                )
                Text(text = "Poland", modifier = Modifier.layoutId("countryText"))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .layoutId("rowstate")


                ) {
                    ProfileStates(count = "150", title = "Folowers")
                    ProfileStates(count = "100", title = "Folowings")
                    ProfileStates(count = "15", title = "Posts")


                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("followbutton")

                ) {
                    Text(text = "Follow User")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("directmessage")


                ) {
                    Text(text = "Direct Message")

                }

            }
        }

    }
}

@Composable
fun ProfileStates(count:String,title: String){
    Column(horizontalAlignment =Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)

    }

}

private fun portraitConstraints(margin: Dp):ConstraintSet{
    return ConstraintSet{
        val image=createRefFor("image")
        val nameText=createRefFor("nameText")
        val countryText=createRefFor("countryText")
        val rowstate=createRefFor("rowstate")
        val followbutton=createRefFor("followbutton")
        val directmessage=createRefFor("directmessage")
        val guideline=createGuidelineFromTop(0.1f)


        constrain(image){
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowstate){
            top.linkTo(countryText.bottom)
        }
        constrain(followbutton){
            top.linkTo(rowstate.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(directmessage.start)
            width= Dimension.wrapContent
        }
        constrain(directmessage){
            top.linkTo(rowstate.bottom, margin = margin)
            start.linkTo(followbutton.end)
            end.linkTo(parent.end)
            width= Dimension.wrapContent
        }

    }
}
private fun landscapeConstraints(margin: Dp):ConstraintSet{
    return ConstraintSet{
        val image=createRefFor("image")
        val nameText=createRefFor("nameText")
        val countryText=createRefFor("countryText")
        val rowstate=createRefFor("rowstate")
        val followbutton=createRefFor("followbutton")
        val directmessage=createRefFor("directmessage")
        val guideline=createGuidelineFromTop(0.2f)
        constrain(image){
            top.linkTo(parent.top,margin=margin)
            start.linkTo(parent.start,margin=margin)

        }
        constrain(nameText){
            start.linkTo(image.start)
            top.linkTo(image.bottom)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)

        }
        constrain(rowstate){
            top.linkTo(image.top)
            start.linkTo(image.end,margin=margin)
            end.linkTo(parent.end)

        }
        constrain(followbutton){
            top.linkTo(rowstate.bottom,margin=16.dp)
            start.linkTo(rowstate.start)
            end.linkTo(directmessage.start)
            bottom.linkTo(countryText.bottom)
            width= Dimension.wrapContent

        }
        constrain(directmessage){
            top.linkTo(rowstate.bottom,margin=16.dp)
            start.linkTo(followbutton.start)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width= Dimension.wrapContent

        }


    }

}

@Preview(showBackground = true)
@Composable
fun ProfilepagePreview(){
    Profilepage()

}

