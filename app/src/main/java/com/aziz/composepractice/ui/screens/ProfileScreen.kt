package com.aziz.composepractice.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.aziz.composepractice.R
import com.aziz.composepractice.data.StoryHighlights
import com.aziz.composepractice.ui.common.POST_VIEW_ROUTE

@ExperimentalFoundationApi
//@Preview(
//    name = "instagram",
//    group = "instagram",
//    showSystemUi = true,
//    showBackground = true
//)
@Composable
fun ProfileScreen(navController: NavController) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    var scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth()) {

        TopBar(name = "rasulmetov_a", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.padding(3.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ProfileSection()
            Spacer(modifier = Modifier.height(10.dp))
            ButtonSection(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            HighlightSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                highlights = listOf(
                    StoryHighlights(
                        image = painterResource(id = R.drawable.youtube),
                        text = "YouTube"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.qa),
                        text = "Q&A"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.discord),
                        text = "Discord"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.telegram),
                        text = "Telegram"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.youtube),
                        text = "YouTube"
                    ),
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            PostTabView(
                imageWithText = listOf(
                    StoryHighlights(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Text"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text = "Text"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.ic_reels),
                        text = "Text"
                    ),
                    StoryHighlights(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text = "Text"
                    )
                ),
                onTabSelected = { index ->
                    selectedTabIndex = index
                },
            )
            when (selectedTabIndex) {
                0 -> {
                    PostSection(
                        posts = listOf(
                            painterResource(id = R.drawable.kmm),
                            painterResource(id = R.drawable.intermediate_dev),
                            painterResource(id = R.drawable.master_logical_thinking),
                            painterResource(id = R.drawable.bad_habits),
                            painterResource(id = R.drawable.multiple_languages),
                            painterResource(id = R.drawable.learn_coding_fast)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        navController = navController
                    )
                }
            }
        }
    }

}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back btn",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Bell icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.philipp),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(3.dp))
        ProfileDescription(
            "Programming Mentor",
            "10 years of coding experience\n" +
                    "Want me to make your app? Send me an email!\n" +
                    "Android tutorials? Subscribe to my channel!",
            "https://www.google.com/phillip_lackener",
            listOf("Aziz", "coding_in_flow", "hogn_ate"),
            17
        )
    }
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")
    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 85.dp
    val height = 30.dp
    Row(
        modifier = modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ActionButton(
            title = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            title = "Message",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            title = "Email",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height = height)
        )
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlights>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(image = highlights[it].image, modifier = Modifier.size(70.dp))
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<StoryHighlights>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, storyHighlights ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(selectedTabIndex)
                }
            ) {
                Icon(
                    painter = storyHighlights.image,
                    contentDescription = storyHighlights.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)

    ) {
        items(posts.size) {
            Box(modifier = Modifier.clickable {
                navController.navigate(POST_VIEW_ROUTE)
            }) {
                Image(
                    painter = posts[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(
                            width = 1.dp,
                            color = Color.White
                        )
                )
            }
        }
    }
}


@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
    modifier: Modifier = Modifier
) {
    val lineHeight = 20.sp
    val letterSpacing = 0.5.sp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = description,
            fontSize = 14.sp,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            fontSize = 14.sp,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight,
                fontSize = 14.sp
            )
        }
    }
}


@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: ImageVector? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        title?.let {
            Text(
                text = it,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = numberText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun RoundImage(image: Painter, modifier: Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}