package com.devyoussef.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyoussef.designsystem.R
import com.devyoussef.designsystem.theme.SahetyTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


//@Composable
//fun SplashScreen(modifier: Modifier = Modifier, navigateToOnBoarding: () -> Unit = {}) {
//    // Animation states
//    val logoSize = remember { Animatable(100f) }
//    val logoOffsetX = remember { Animatable(0f) }
//    val textAlpha = remember { Animatable(0f) }
//    val textProgress = remember { Animatable(0f) }
//
//    val appName = "Sahety"
//    val animatedText = buildAnnotatedString {
//        val visibleCharCount = (appName.length * textProgress.value).toInt()
//
//        appName.forEachIndexed { index, char ->
//            val alpha = if (index < visibleCharCount) {
//                1f
//            } else if (index == visibleCharCount) {
//                textProgress.value % (1f / appName.length) * appName.length
//            } else {
//                0f
//            }
//
//            withStyle(
//                style = SpanStyle(
//                    color = SahetyTheme.colors.primaryText.copy(alpha = alpha)
//                )
//            ) {
//                append(char.toString())
//            }
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        // 1. Initial state - logo centered at 100dp, text invisible
//        delay(500)
//
//        // 2. First shrink the logo while staying centered
//        logoSize.animateTo(
//            targetValue = 58f,
//            animationSpec = tween(durationMillis = 500)
//        )
//
//
//        // 4. Fade in text container and animate characters
//        textAlpha.animateTo(1f, animationSpec = tween(100))
//        textProgress.animateTo(
//            targetValue = 1f,
//            animationSpec = tween(
//                durationMillis = appName.length * 80,
//                easing = LinearOutSlowInEasing
//            )
//        )
//
//        // 5. Navigate after animations complete
////        delay(800)
////        navigateToOnBoarding()
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(SahetyTheme.colors.bgColor),
//        contentAlignment = Alignment.Center
//    ) {
//        // This Box acts as our centered container that won't move
//        Box(modifier = Modifier.offset(x = logoOffsetX.value.dp)) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.ic_logo),
//                    contentDescription = null,
//                    modifier = modifier.size(logoSize.value.dp)
//                )
//
//                Text(
//                    text = animatedText,
//                    modifier = modifier
//                        .padding(start = 16.dp)
//                        .alpha(textAlpha.value),
//                    style = TextStyle(
//                        fontSize = 32.sp,
//                        fontWeight = FontWeight.Bold,
//                        fontFamily = FontFamily(Font(R.font.nunito_bold))
//                    )
//                )
//            }
//        }
//    }
//}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToOnBoarding: () -> Unit = {}
) {
    val imageOpacity = remember { Animatable(0f) }
    val imageSize = remember { Animatable(100f) }
    val textProgress = remember { Animatable(0f) }
    val textAlpha = remember { Animatable(0f) }

    val appTitle = "Sehaty"

    // Build animated text
    val animatedText = buildAnnotatedString {
        val visibleCharCount = (appTitle.length * textProgress.value).toInt()

        appTitle.forEachIndexed { index, char ->
            val alpha = if (index < visibleCharCount) {
                1f
            } else if (index == visibleCharCount) {
                textProgress.value % (1f / appTitle.length) * appTitle.length
            } else {
                0f
            }

            withStyle(
                style = SpanStyle(
                    color = SahetyTheme.colors.primaryText.copy(alpha = alpha)
                )
            ) {
                append(char.toString())
            }
        }
    }


    LaunchedEffect(Unit) {
        // 1. Fade in logo
        imageOpacity.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 200)
        )

        // 2. Shrink logo after delay
        delay(300)
        imageSize.animateTo(
            targetValue = 58f,
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
        )

        // 3. Start text fade in
        textAlpha.animateTo(1f, animationSpec = tween(durationMillis = 100))

        // 4. Animate text
        textProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = appTitle.length * 80,
                easing = LinearOutSlowInEasing
            )
        )

        delay(1000)
//        navigateToOnBoarding()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(SahetyTheme.colors.bgColor),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Logo
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(imageSize.value.dp)
                    .alpha(imageOpacity.value)
            )

            // Only show text once first character should appear
            AnimatedVisibility(
                visible = textProgress.value > 0f,
                enter = fadeIn(tween(300)) + expandHorizontally(expandFrom = Alignment.Start),
                exit = fadeOut()
            ) {
                Text(
                    text = animatedText,
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                )
            }


        }
    }
}

