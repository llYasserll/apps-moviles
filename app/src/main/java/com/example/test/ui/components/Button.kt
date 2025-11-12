package com.example.test.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.Black
import com.example.test.ui.theme.RedPink

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 40.dp,
    cornerRadius: Dp = 10.dp,
    backgroundColor: Color = RedPink,
    textColor: Color = Black,
    fontSize: Int = 20,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.4f)
        ),
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier.height(height)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PrimaryCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 12.dp,
    elevation: Dp = 6.dp,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black,
    onClick: (() -> Unit)? = null
) {
    Card( modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)
        .then(
            if (onClick != null) Modifier.clickable { onClick() } else Modifier
        ),elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column (modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                fontSize = 16.sp
            )
        }
    }
}
