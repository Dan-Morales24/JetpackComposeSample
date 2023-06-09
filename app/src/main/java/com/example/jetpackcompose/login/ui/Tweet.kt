package com.example.jetpackcompose.login.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R


@Preview(showBackground = true)
@Composable
fun Tweet(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF161D26))
    ) {
        HeaderTweet()
        TweetDivider()
        HeaderTweet()
    }

    }

@SuppressLint("ResourceType")
@Composable
fun HeaderTweet() {
    var chat by remember{ mutableStateOf(false)}
    var like by remember{ mutableStateOf(false)}
    var rt by remember{ mutableStateOf(false)}
    var share by remember{ mutableStateOf(false)}


    Row(
        Modifier
            .fillMaxWidth()
            // .background(Color(0xFF161D26))
            .padding(16.dp)


    ){
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Logo app",
        modifier = Modifier
            .size(55.dp)
            .clip(CircleShape)

    )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
                Row(
                    Modifier.fillMaxWidth()
                )
                    {
                        NamePerson("Juan Daniel",Modifier.padding(end = 8.dp))
                        HashTag( "@DANIEL",Modifier.padding(end = 8.dp))
                        TimePublication("6Hrs",Modifier.padding(end = 8.dp))
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(painterResource(R.xml.ic_dots), contentDescription = "", tint = Color.Gray)

                    }

                    Content("Esto es un texto lago, probando estructura"+
                            "Esto es un texto lago, probando estructura"+
                            "Esto es un texto lago, probando estructura"+
                            "Esto es un texto lago, probando estructura"+
                            "Esto es un texto lago, probando estructura"+
                            "Esto es un texto lago, probando estructura")

                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Logo app",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .clip(RoundedCornerShape(10)),
                        contentScale = ContentScale.Crop

                    )

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ){
                        Row(
                            Modifier.fillMaxWidth()
                        ){
                           Views("31 views")
                        }

                    Row(
                        Modifier.padding(top = 16.dp)
                    ){
                        // Comentarios
                        SocialIcons(
                                    modifier = Modifier.weight(1f),
                                    unselectedIcon = {
                                        Icon( painterResource(id = R.xml.ic_chat), "",tint = Color (0xFF7E8B98)
                                        )
                                    }, selectedIcon = {
                                        Icon(painterResource(id  = R.xml.ic_chat_filled), "", tint = Color(0xFF7E8B98)
                                        )
                                    }, isSelected = chat
                                ){ chat = !chat }

                        //Like
                        SocialIcons(
                            modifier = Modifier.weight(1f),
                            unselectedIcon = {
                                Icon( painterResource(id = R.xml.ic_like), "Icon chat", tint = Color (0xFF7E8B98)
                                )
                            }, selectedIcon = {
                                Icon(painterResource(id  = R.xml.ic_like_filled), "", tint = Color(0xFFFF0000)
                                )
                            }, isSelected = like
                        ){ like = !like }

                        //Recycle
                        SocialIcons(
                            modifier = Modifier.weight(1f),
                            unselectedIcon = {
                                Icon( painterResource(id = R.xml.ic_rt), "Icon chat", tint = Color (0xFF7E8B98)
                                )
                            }, selectedIcon = {
                                Icon(painterResource(id  = R.xml.ic_rt), "", tint = Color(0xFF00ff27)
                                )
                            }, isSelected = rt
                        ){ rt = !rt }

                        //Share
                        SocialIcons(
                            modifier = Modifier.weight(1f),
                            unselectedIcon = {
                                Icon( painterResource(id = R.xml.ic_share), "Icon chat", tint = Color (0xFF7E8B98)
                                )
                            }, selectedIcon = {
                                Icon(painterResource(id  = R.xml.ic_share), "", tint = Color(0xFF1305E1)
                                )
                            }, isSelected = share
                        ){ share = !share }



                    }


                }



             }

        }

    }

@Composable
fun Content(text: String, modifier: Modifier = Modifier ) {
    Text(text = text, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}


@Composable
fun NamePerson(title:String, modifier:Modifier = Modifier){
        Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun HashTag(title:String, modifier:Modifier = Modifier){
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun TimePublication(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun Views(title: String, modifier: Modifier = Modifier){
    Text(text = title, color = Color.Gray, modifier = modifier)

}

    @Composable
    fun SocialIcons(
     modifier: Modifier,
     unselectedIcon: @Composable () -> Unit,
     selectedIcon: @Composable () -> Unit,
     isSelected: Boolean,
     onItemSelected: () -> Unit

    ){
        val defaultValue = 1
        Row(modifier = modifier.clickable { onItemSelected() }, verticalAlignment = Alignment.CenterVertically){
            if(isSelected){
                selectedIcon()
            }
            else{
                unselectedIcon()
            }
            Text(text = if(isSelected)(defaultValue+1).toString() else defaultValue.toString(),
                 color = Color(0xFF7E8B98),
                 fontSize = 12.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }


    @Composable
    fun TweetDivider(){
     Divider(
         Modifier
             .padding(top = 4.dp)
             .height(1.dp)
             .fillMaxWidth(),
         color = Color(0xFF7e8B98)
     )
    }







