package com.example.harajtask.presentation.car_list.components


//import androidx.compose.foundation.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.core.graphics.scaleMatrix
import coil.compose.rememberImagePainter
import com.example.harajtask.R
import com.example.harajtask.domain.model.Haraj


@Composable
fun CarListItem(
    car: Haraj,
    onItemClick: (Haraj) -> Unit
){
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .clickable { onItemClick(car) }
           .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
   ){
       Column(
           modifier = Modifier

       ) {
           Image(
               painter = rememberImagePainter(car.thumbURL),
               contentDescription = null,
               contentScale = ContentScale.FillBounds,
               modifier = Modifier
                   .clip(shape = RoundedCornerShape(12.dp))
                   .size(160.dp, 120.dp),
           )
       }

       Column (
           modifier = Modifier
               .fillMaxSize()
               .padding(start = 20.dp, end = 0.dp),
               horizontalAlignment = Alignment.End
       ){
           Text(
               buildAnnotatedString {
                   withStyle(style= SpanStyle(
                       color = androidx.compose.ui.graphics.Color.Green)){
                        append("${car.title}")

                   }
               },
               overflow = TextOverflow.Ellipsis,
               textAlign = TextAlign.Right,
               style = MaterialTheme.typography.body1,

           )
           Text(
               text = "${car.date}",
               textAlign = TextAlign.Right,
               style = MaterialTheme.typography.body2,
               overflow = TextOverflow.Ellipsis,
               modifier = Modifier.padding(top = 5.dp),

           )
           Text(
               text = "${car.commentCount}",
               textAlign = TextAlign.Right,
               style = MaterialTheme.typography.body2,
               overflow = TextOverflow.Ellipsis,
               modifier = Modifier.padding(top = 5.dp),
           )

           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(top=5.dp),
                   horizontalArrangement = Arrangement.SpaceBetween
           ){


            Row() {
                Text(
                    text = "${car.city}",

                    style = MaterialTheme.typography.body2,

                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Location",
                    modifier = Modifier.size(15.dp )
                        .padding(start = 5.dp)
                )
            }

            Row(

            ) {
                Text(
                    text = "${car.username}",

                    style = MaterialTheme.typography.body2,

                    modifier = Modifier.padding(end = 10.dp)

                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "Location",
                    modifier = Modifier.size(15.dp )

                )
            }


           }

        }
   }
}