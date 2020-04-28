package android.example.com.jokedisplay;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class JokeActivityTest {
    @Rule
    public ActivityTestRule<JokeActivity> mActivityTestRule = new ActivityTestRule<>(JokeActivity.class);

    @Test
    public void testMainActivity_ClickJokeButton() {

        String noJokeMessage = mActivityTestRule.getActivity().getString(R.string.no_joke);

        onView(ViewMatchers.withId(R.id.tv_joke)).check(matches(not(withText(noJokeMessage))));
    }
}
