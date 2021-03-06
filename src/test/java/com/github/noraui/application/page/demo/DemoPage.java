/**
 * NoraUi is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.noraui.application.page.demo;

import static com.github.noraui.utils.Context.DEMO_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.page.Page;
import com.github.noraui.exception.Callbacks;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Utilities;
import com.google.inject.Singleton;

@Singleton
public class DemoPage extends Page {

    /**
     * Specific logger
     */
    protected static final Logger logger = LoggerFactory.getLogger(DemoPage.class);

    public final PageElement bigTitle = new PageElement("-big_title", "This is a demo for NORAUI (Non-Regression Automation for User Interfaces).");
    public final PageElement inputSelect = new PageElement("-input_select_field", "Input Select field");
    public final PageElement rateRadio = new PageElement("-rate", "Input radio rate");
    public final PageElement agreeCheckbox = new PageElement("-agree", "Input checkbox agree");
    public final PageElement submit = new PageElement("-submit", "Submit button");
    public final PageElement smilejs = new PageElement("-smilejs", "link a html balise with onclick by js (smilejs)");
    public final PageElement smile = new PageElement("-smile", "link a html balise with onclick (smile)");
    public final PageElement noExistElement = new PageElement("-noExistElement", "no exist element");
    public final PageElement message = new PageElement("-message", "message");
    public final PageElement xpathContainPercentChar = new PageElement("-xpathContainPercentChar");
    public final PageElement changeValueButton = new PageElement("-changeValueButton");
    public final PageElement disappearButton = new PageElement("-disappearButton");
    public final PageElement staleButton = new PageElement("-staleButton");

    private static final String TITLE_PAGE = "NoraUi Demo";

    public DemoPage() {
        super();
        this.application = DEMO_KEY;
        this.pageKey = "DEMO_HOME";
        this.callBack = Context.getCallBack(Callbacks.CLOSE_WINDOW_AND_SWITCH_TO_DEMO_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                logger.error("HTML title is not good");
                return false;
            }
        } catch (final Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
        try {
            if (bigTitle.getLabel().equals(Utilities.findElement(bigTitle).getText())) {
                return true;
            }
            logger.error("Big title is not good");
            return false;
        } catch (final Exception e) {
            logger.error("Big title Exception", e);
            return false;
        }
    }

}