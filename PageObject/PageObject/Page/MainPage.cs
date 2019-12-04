using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.PageObjects;

namespace PageObject.Page
{
    class MainPage
    {
       

        [FindsBy(How = How.Id, Using = "querytext")]
        private IWebElement Poisk;
        [FindsBy(How = How.ClassName, Using = "search-button__label")]
        private IWebElement PoiskButton;
        [FindsBy(How = How.ClassName, Using = "df_overlay js-overlay")]
        private IWebElement Close;
        [FindsBy(How = How.ClassName, Using = "df_label")]
        private IWebElement Message;

        public MainPage(IWebDriver browser)
        {
            PageFactory.InitElements(browser, this);
        }

        public MainPage InputPoisk(string q)
        {
            Poisk.SendKeys(q);
            Thread.Sleep(5000);
            PoiskButton.Click();
            Thread.Sleep(3000);
            Message.Click();
            return this;
        }


        [FindsBy(How = How.XPath, Using = @"//*/div/div[1]/button/span")]
        private IWebElement enter;
        [FindsBy(How = How.Id, Using = @"check_email")]
        private IWebElement email;
        [FindsBy(How = How.Id, Using = @"login_email_submit")]
        private IWebElement next;
        [FindsBy(How = How.Id, Using = @"register_password")]
        private IWebElement registerPass;
        [FindsBy(How = How.Id, Using = @"register_email_submit")]
        private IWebElement registerEmailSubmit;



        public MainPage InputFilter(string filt, string pass)
        {
            enter.Click();
            email.Click();
            email.SendKeys(filt);
            next.Click();
            registerPass.Clear();
            registerPass.Click();
            Thread.Sleep(5000);
            registerPass.SendKeys(pass);
            registerEmailSubmit.Click();          
            return this;
        }
    }
}
