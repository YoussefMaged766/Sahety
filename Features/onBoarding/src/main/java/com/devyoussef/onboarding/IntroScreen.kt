package com.devyoussef.onboarding


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyoussef.designsystem.theme.SahetyTheme

@Composable
fun IntroScreen(modifier: Modifier = Modifier , onNavigateToSignUp: () -> Unit = {}) {

    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current

    val screenWidthDp = with(density) { windowInfo.containerSize.width.toDp() }
    val screenHeightDp = with(density) { windowInfo.containerSize.height.toDp() }

    Scaffold { innerPadding ->

        Box(
            modifier = modifier
                .fillMaxSize()
                .background(SahetyTheme.colors.primaryContainer)
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Image(
                    painter = painterResource(com.devyoussef.designsystem.R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
//                    .offset(x = (-100).dp, y = (140).dp)
//                    .offset(x = screenWidthDp * 0.04f, y = screenHeightDp * 0.13f)
                        .offset(x = -screenWidthDp * 0.21f, y = -screenHeightDp * 0.08f)
                        .rotate(23f),
                    colorFilter = ColorFilter.tint(Color(0xff06FF75).copy(alpha = 0.3f)),
                    contentScale = ContentScale.Fit

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    modifier = Modifier.padding(top = 30.dp, start = 18.dp),
                    text = stringResource(R.string.your_health_journey_starts_here),
                    fontSize = 32.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(resId = com.devyoussef.designsystem.R.font.nunito_bold)),
                )
                Image(
                    painter = painterResource(R.drawable.img_intro),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .aspectRatio(0.8f, matchHeightConstraintsFirst = true),
                )
            }


            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                SahetyTheme.colors.primaryContainer.copy(0.5f),
                                SahetyTheme.colors.primaryContainer.copy(0.3f),
                                SahetyTheme.colors.primaryContainer
                            )
                        )
                    )
            ) {

                Column(modifier = Modifier.align(Alignment.Center)) {
                    ElevatedButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp),
                        onClick = {},
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 17.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.sign_in), style = TextStyle(
                                fontSize = 16.sp,
                                color = SahetyTheme.colors.primaryContainer,
                                fontFamily = FontFamily(Font(resId = com.devyoussef.designsystem.R.font.nunito_regular))
                            )
                        )
                    }

                    Spacer(modifier = Modifier.heightIn(16.dp))

                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp),
                        onClick = {
                            onNavigateToSignUp()
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(
                            width = 2.dp, color = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 17.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.sign_up), style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(resId = com.devyoussef.designsystem.R.font.nunito_regular))
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun IntroScreenPreview() {
    IntroScreen(modifier = Modifier)
}