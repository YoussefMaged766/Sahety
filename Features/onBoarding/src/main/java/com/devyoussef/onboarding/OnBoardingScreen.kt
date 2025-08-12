package com.devyoussef.onboarding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devyoussef.designsystem.theme.SahetyTheme
import com.devyoussef.onboarding.model.OnBoardingModel
import com.devyoussef.onboarding.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigateToOnBoarding: () -> Unit,
    navigateToIntro: () -> Unit
) {
    val currentPageIndex by viewModel.currentPageIndex
    val direction by viewModel.direction


    val onBoardingItems = remember {
        listOf(
            OnBoardingModel(
                R.drawable.onboarding_img1,
                R.string.book_your_doctor_in_seconds,
                R.string.all_specialties_in_one_place_choose_from_top_rated_doctors_near_you
            ),
            OnBoardingModel(
                R.drawable.onboarding_img2,
                R.string.your_care_starts_with_one_tap,
                R.string.search_book_and_follow_up_all_in_one_app
            ),
            OnBoardingModel(
                R.drawable.onboarding_img3,
                R.string.your_health_matters_most_anytime,
                R.string.we_connect_you_to_the_best_doctors_quickly_and_effortlessly
            )
        )
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .background(SahetyTheme.colors.bgColor)
                .padding(innerPadding)
                .padding(horizontal = 18.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                OnboardPage(page = onBoardingItems[currentPageIndex], direction = direction)
            }

            OnBoardingBottomScreen(
                currentPage = currentPageIndex,
                items = onBoardingItems,
                onNextClick = {
                    viewModel.handleNextClick(onBoardingItems.size , navigateToIntro)
                },
                onPreviousClick = {
                    viewModel.previousPage()
                }
            )
        }
    }
}


@Composable
fun OnboardPage(
    modifier: Modifier = Modifier,
    page: OnBoardingModel,
    direction: Int // pass it here
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fade in image only
        Crossfade(targetState = page.image, label = "ImageCrossfade") { imageRes ->
            Image(
                painter = painterResource(imageRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            AnimatedContent(page.title, transitionSpec = {
                val slideOffset =
                    if (direction >= 0) { height: Int -> height } else { height: Int -> -height }

                slideInVertically(
                    animationSpec = tween(500),
                    initialOffsetY = slideOffset
                ) + fadeIn() togetherWith
                        slideOutVertically(
                            animationSpec = tween(500),
                            targetOffsetY = slideOffset
                        ) + fadeOut()
            }) { title ->
                Text(
                    text =stringResource(title) ,
                    modifier = Modifier.fillMaxWidth(),
                    color = SahetyTheme.colors.primaryText,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(resId = com.devyoussef.designsystem.R.font.nunito_bold))
                )
            }


            Spacer(modifier = Modifier.height(18.dp))
            AnimatedContent(page.description, transitionSpec = {
                val slideOffset =
                    if (direction >= 0) { height: Int -> height } else { height: Int -> -height }

                slideInVertically(
                    animationSpec = tween(500),
                    initialOffsetY = slideOffset
                ) + fadeIn() togetherWith
                        slideOutVertically(
                            animationSpec = tween(500),
                            targetOffsetY = slideOffset
                        ) + fadeOut()
            }) { description ->
                Text(
                    text =stringResource(description) ,
                    modifier = Modifier.fillMaxWidth(),
                    color = SahetyTheme.colors.secondaryText,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(resId = com.devyoussef.designsystem.R.font.nunito_regular))
                )
            }

        }
//        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Composable
fun OnBoardingBottomScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit = {},
    onPreviousClick: () -> Unit = {},
    currentPage: Int,
    items: List<OnBoardingModel>
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                if (currentPage > 0) {
                    TextButton(onClick = onPreviousClick) {
                        Icon(
                            Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = SahetyTheme.colors.secondaryText
                        )
                        Text(
                            text = stringResource(R.string.previous),
                            modifier = Modifier.padding(start = 4.dp),
                            color = SahetyTheme.colors.secondaryText
                        )
                    }
                }
            }

            PageIndicator(
                modifier = Modifier.weight(1f),
                currentPage = currentPage,
                items = items
            )

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(onClick = onNextClick) {
                    Text(
                        text = stringResource(R.string.next),
                        modifier = Modifier.padding(end = 4.dp),
                        color = SahetyTheme.colors.primaryContainer
                    )
                    Icon(
                        Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                        contentDescription = null,
                        tint = SahetyTheme.colors.primaryContainer
                    )
                }
            }
        }
    }

}


@Composable
fun PageIndicator(modifier: Modifier, currentPage: Int, items: List<OnBoardingModel>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage)
        }
    }

}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 24.dp else 13.dp, animationSpec = spring(
            stiffness = Spring.StiffnessMedium,
            dampingRatio = Spring.DampingRatioMediumBouncy
        )
    )

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(8.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) SahetyTheme.colors.primaryContainer else Color(0xFF6E6E6E)
            )
    )
}