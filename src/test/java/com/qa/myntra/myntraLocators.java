package com.qa.myntra;

import org.openqa.selenium.By;


public class myntraLocators {
    public static By profileIcon = By.xpath("//span[@class='myntraweb-sprite desktop-iconUser sprites-headerUser']");
    public static By myntraIcon = By.xpath("//script[@data-release='vendor']");
    public static By loginOption = By.xpath("//a[@class='desktop-linkButton']");
    public static By continueButton = By.xpath("//div[@class='submitBottomOption']");
    public static By invalidMobileNoError = By.xpath("//div[@class='errorContainer']");
    public static By termsOfUse = By.xpath("//a[normalize-space()='Terms of Use']");
    public static By privacyPolicy = By.xpath("//a[normalize-space()='Privacy Policy']");
    public static By sortTab = By.xpath("//label[@class='sort-label ']");
    public static By tshirtsFilter = By.xpath("(//div[@class='common-checkboxIndicator'])[1]");
    public static By clearAllButton = By.xpath("//span[@class='header-clearAllBtn']");
    public static By tempFilterTag = By.xpath("//div[@class='filter-summary-filter']");
    public static By priceFilter = By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[3]");
    public static By discountFilter = By.xpath("(//label[@class='common-customRadio vertical-filters-label'])[1]");
    public static By colorFilter = By.xpath("(//div[@class='common-checkboxIndicator'])[15]");
    public static By brandFabfleeFilter = By.xpath("(//div[@class='common-checkboxIndicator'])[3]");

    public static By mobileNumberField = By.xpath("//input[@class='form-control mobileNumberInput']");

    public static By mainPageElements1 = By.xpath("//a[@class='desktop-main']");
    public static By mainPageElements2 = By.xpath("//span[@class='desktop-userTitle']");
    public static By searchTab = By.xpath("//input[@class='desktop-searchBar']");

    public static By filterTagElement = By.xpath("//span[@class='vertical-filters-header']");
    public static By categoryTag = By.xpath("//div[@class='vertical-filters-filters categories-container']//label[@class='common-customCheckbox vertical-filters-label']");
    public static By brandTag = By.xpath("//div[@class='vertical-filters-filters brand-container']//label[@class='vertical-filters-label common-customCheckbox']");
    public static By priceTag = By.xpath("//div[@class='vertical-filters-filters']//label[@class='common-customCheckbox vertical-filters-label']");
    public static By colorTag = By.xpath("//div[@class='vertical-filters-filters']//li[@class='colour-listItem']");
    public static By colorMoreTag = By.xpath("//div[@class='colour-more']//span");
    public static By discountRangeTag = By.xpath("//div[@class='vertical-filters-filters']//label[@class='common-customRadio vertical-filters-label']");
    public static By brandMoreTag = By.xpath("//div[@class='brand-more']");
    public static By brandMorePage = By.xpath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']");
    public static By brandMorePageOpen = By.xpath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']");
    public static By brandMorePageTag = By.xpath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']//ul[@class='FilterDirectory-list']//li");
    public static By desktopContainerWomen = By.xpath("(//div[@class='desktop-categoryContainer'])[2]");
    public static By menWearPageText = By.xpath("//div[@class='breadcrumbs-base']");
    public static By searchBrandTag = By.xpath("//input[@class='FilterDirectory-searchInput']");
    public static By brandTextInSearchTab = By.xpath("//label[@class=' common-customCheckbox']");
    public static By brandCheckBox = By.xpath("//label[@class=' common-customCheckbox']//div[@class='common-checkboxIndicator']");
    public static By homePageImg = By.xpath("//div[@class='search-searchProductsContainer row-base']//img[@class='img-responsive']");
    public static By homePageBrandName = By.xpath("//h3[@class='product-brand']");
    public static By brandPageCloseButton = By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']");
    public static By nextButton = By.xpath("//li//a[@rel='next']");
    public static By previousButton = By.xpath("//li[@class='pagination-prev']");
    //    static String firstimg = homepageimg + "[1]";
    public static By firstImgClick = By.xpath("//li[@class='product-base'][1]");
    public static By firstImgText(int i) {
        return By.xpath("(//h3[@class='product-brand'])" + "[" + i + "]");
    }

    public static By firstImgNewWindow = By.xpath("//h1[@class='pdp-title']");
    public static By addToBag = By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']");
    public static By sizeChartButton = By.xpath("//button[@class='size-buttons-show-size-chart']");
    public static By addToBagError = By.xpath("//span[@class='size-buttons-size-error-message']");
    public static By sizeButton = By.xpath("//button[@class='size-buttons-size-button size-buttons-size-button-default']");
    public static By inchButton = By.xpath("//button[@id='Inches']");
    public static By centimeterButton = By.xpath("//button[@id='cm']");
    public static By addToBagPopup = By.xpath("//p[@class='notify-thumbnail-text']");
    public static By deliveryCheckError = By.xpath("//div[@class='notify-error-message']");
    public static By deliveryMoreInfo = By.xpath("//span[@class='pincode-serviceabilityViewMore']");
    public static By moreInfoCloseButton = By.xpath("//div[@class='halfcard-gridHeaderLeft']");
    public static By easyExchangeAndReturnHeading = By.xpath("//div[@class='halfcard-gridHeaderTitle']");
    public static By goToBag = By.xpath("//a[@class='pdp-goToCart pdp-add-to-bag pdp-button pdp-flex pdp-center ']");
    public static By bagIcon = By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']");
    public static By addToBagTextPopup = By.xpath("//span[contains(@class,'desktop-badge')]");
    public static By sizeChartCloseButton = By.xpath("//span[@class='myntraweb-sprite sizeChartWeb-modalclose sprites-modalclose']");
    public static By deliveryTextBox = By.xpath("//input[@class='pincode-code']");
    public static By deliveryCheckButton = By.xpath("//div[@class='pincode-deliveryContainer']//input[@type='submit']");
    public static By deliveryGreenCheck = By.xpath("//div[@class='pincode-tick sprites-lightTick']");
    public static By deliveryChangeButton = By.xpath("//button[@class='pincode-check-another-pincode pincode-button']");
    public static By secureElement = By.xpath("//div[@class='secure']");
    public static By placeOrderButton = By.xpath("//button[@class='css-etguer']");
    public static By removeButton1 = By.xpath("//button[contains(@class,'Remove')]");
    public static By removeButton2 = By.xpath("//button[@class='inlinebuttonV2-base-actionButton ']");
    public static By removeButtonConfirmationPage = By.xpath("//div[@class='modal-base-modal bulkActionStrip-confirmationModalDesktop']");
    public static By moveToWishlistButton = By.xpath("//button[contains(@class,'Wishlist')]");
    public static By addedItemConfirmation = By.xpath("//div[@class='itemContainer-base-item ']");
    public static By checkoutFullPage = By.xpath("//div[@class='itemComponents-base-invisibleBackDrop']");
    public static By addItemFromWishlist = By.xpath("//div[@class='button-base-button emptyCart-base-wishlistButton ']");
    public static By wishlistScreenLoginButton = By.xpath("//a[@class='wishlistLogin-button']");
}




