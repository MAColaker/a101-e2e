package org.colaker.pages;

import org.openqa.selenium.By;

public class AnaSayfa {

    public By a101Logo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/" +
            "android.widget.ImageView");
    public By hamburgerMenu = By.xpath("(//*[@resource-id='android:id/content']//*[@class='android.widget.TextView'])[1]");
    public By giyimVeAksesuarMenu = By.xpath("//*[@resource-id='android:id/content']//*[@class='android.widget.TextView'][contains(@text,'GİYİM')]");
    public By kadinIcGiyimMenu = By.xpath("//*[@resource-id='android:id/content']//*[@class='android.widget.TextView'][@text='Kadın İç Giyim']");
    public By dizaltiCorapMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/" +
            "android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.TextView");

}
