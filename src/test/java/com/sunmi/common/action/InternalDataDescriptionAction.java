package com.sunmi.common.action;

import com.sunmi.common.selector.InternalDataDescriptionSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 22:48
 */
@Component
public class InternalDataDescriptionAction extends AbstractAction {

    @Autowired
    private InternalDataDescriptionSelector internalDataDescriptionSelector;

    public void scrollInternalDataDescriptionDialog(String dialogName, String inputText) {
        WebElement webElement = internalDataDescriptionSelector.getDescriptionDialogInputText(dialogName, inputText);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).perform();
    }

    public void clickNewDescriptionButton() {
        internalDataDescriptionSelector.getNewDescriptionButton().click();
    }

    public void checkNewDescriptionDialogCheckBox(String dialogName, String checkBox, boolean checked) {
        WebElement webElement = internalDataDescriptionSelector.getDescriptionDialogCheckBox(dialogName, checkBox);
        if (webElement.isSelected() != checked) {
            webElement.click();
        }
    }

    public void sendKeyNewDescriptionDialogInputText(String dialogName, String inputText, String text) {
        WebElement webElement = internalDataDescriptionSelector.getDescriptionDialogInputText(dialogName, inputText);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void clickKeyNewDescriptionDialogConfirm(String dialogName) {
        internalDataDescriptionSelector.getDescriptionDialogConfirm(dialogName).click();
    }

    public void clickNewDescriptionDialogCancel(String dialogName) {
        internalDataDescriptionSelector.getDescriptionDialogCancel(dialogName).click();
    }

    public WebElement getLastDescriptionRow() {
        List<WebElement> webElementList = internalDataDescriptionSelector.getDescriptionRow();
        return webElementList.get(webElementList.size() - 1);
    }

    public void clickDescriptionEditButton(WebElement currentRow) {
        internalDataDescriptionSelector.getDescriptionEditButton(currentRow).click();
    }

    public void clickDescriptionDeleteButton(WebElement currentRow) {
        internalDataDescriptionSelector.getDescriptionDeleteButton(currentRow).click();
    }

    public void clickConfirmDialogButton() {
        internalDataDescriptionSelector.getConfirmDialogButton().click();
    }

    public boolean existsDescriptionTableRow (
            Boolean partnerData, Boolean appData, Boolean deviceData, Boolean financeData,
            String department, String name, String mobile, String email) {
        WebElement currentPanel = internalDataDescriptionSelector.getCurrentPanel();
        List<WebElement> tableRowList = internalDataDescriptionSelector.getDescriptionTableRow(currentPanel);
        boolean exists = false;
        StringBuilder descriptionBuilder = new StringBuilder();
        if (partnerData) {
            descriptionBuilder.append("合作伙伴数据");
        }
        if (appData) {
            descriptionBuilder.append(",").append("应用数据");
        }
        if (deviceData) {
            descriptionBuilder.append(",").append("设备数据");
        }
        if (financeData) {
            descriptionBuilder.append(",").append("金融交易数据");
        }
        for (WebElement tableRow : tableRowList) {
            List<WebElement> tableColList = internalDataDescriptionSelector.getDescriptionTableCol(tableRow);
            for (int i = 0, length = tableColList.size(); i < length; i++) {
                if (department.equals(tableColList.get(0).getText())
                        && name.equals(tableColList.get(1).getText())
                        && mobile.equals(tableColList.get(2).getText())
                        && email.equals(tableColList.get(3).getText())
                        && descriptionBuilder.toString().equals(tableColList.get(4).getText())) {
                    exists = true;
                }
            }
        }
        return exists;
    }

}
