package com.example.jetsample.scenes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.microsoft.appcenter.analytics.Analytics

@OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
@Composable
fun BasicForm(modifier: Modifier = Modifier) {
    var username = remember{ mutableStateOf("") }
    var password = remember{ mutableStateOf("") }
    var propMap = mutableMapOf<String, String>()
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = modifier.padding(4.dp)
            .fillMaxWidth(0.7f)
            .wrapContentHeight(Alignment.CenterVertically))
    {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = "Login Page",
                modifier = modifier.wrapContentWidth(),
                fontSize = TextUnit(24.0f, TextUnitType.Sp),
                fontWeight = FontWeight.Normal
            )
            TextField(value = username.value, onValueChange = {
                username.value = it
            }, placeholder = {
                Text("Enter username")
            })

            TextField(value = password.value, onValueChange = {
                password.value = it
            }, placeholder = {
                Text("Enter password")
            }, )

            Button(onClick = {
                // Track event
                if (username.value.isEmpty() || password.value.length < 5) {
                    Analytics.trackEvent("button_click_invalid_username_or_password")
                } else {
                    propMap.put("username", username.value)
                    propMap.put("password", password.value)
                    Analytics.trackEvent("button_click_valid_username_or_password", propMap)
                }
            }) {
                Text(text = "Click Me")
            }
        }
    }
}

@Preview
@Composable
fun BasicFormPreview() {
    BasicForm()
}