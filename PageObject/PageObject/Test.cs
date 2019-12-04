using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using PageObject.Page;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.PageObjects;

namespace PageObject
{
    [TestClass]
    public class Test
    {
        IWebDriver Browser;
        private static string HomePage = "https://www.trivago.ru/";

        [TestMethod]
        public void TestSearch()
        {
            Browser = new ChromeDriver();
            Browser.Manage().Window.Maximize();
            Browser.Navigate().GoToUrl(HomePage);

            MainPage orderCarPage = new MainPage(Browser)
                .InputPoisk("TestStringTestStringTestStringTestStringTestString");

            Assert.AreEqual(Browser.FindElement(By.ClassName("df_label")).Text,
                "Укажите дату");

            Browser.Quit();
        }

        [TestMethod]
        public void TestFilter()
        {
            Browser = new ChromeDriver();
            Browser.Manage().Window.Maximize();
            Browser.Navigate().GoToUrl(HomePage);

            MainPage orderCarPage = new MainPage(Browser)
                //.InputPoisk("еда")
                .InputFilter("testik313@gmail.com", "123123123");

            Assert.AreEqual(Browser.FindElement(By.ClassName("hero__subtitle")).Text,
                "Здесь можно искать город, конкретный отель или даже известный сайт!");

            Browser.Quit();
        }
    }
}
