package com.sunmi.common.selector;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 20:24
 */
@Component
public class InternalDataDescriptionSelector extends AbstractSelector{

    @Override
    protected String getPage() {
        return "internalDataDescription";
    }

    public WebElement getCurrentPanel () {
        return getElement("internalDataDescriptionPage.currentPanel");
    }

    public WebElement getNewDescriptionButton () {
        return getElement(getCurrentPanel(),"internalDataDescriptionPage.newDescriptionButton");
    }

    public WebElement getDescriptionDialog(String dialogName) {
        return getElementByDynamicArgs("internalDataDescriptionPage.descriptionDialog", dialogName);
    }

    public WebElement getDescriptionDialogCheckBox(String dialogName, String checkBox) {
        return getElementByDynamicArgs("internalDataDescriptionPage.descriptionDialog.checkBox", new String[]{dialogName, checkBox});
    }

    public WebElement getDescriptionDialogInputText(String dialogName, String inputText) {
        return getElementByDynamicArgs("internalDataDescriptionPage.descriptionDialog.inputText", new String[]{dialogName, inputText});
    }

    public WebElement getDescriptionDialogConfirm(String dialogName) {
        return getElementByDynamicArgs(getCurrentPanel(), "internalDataDescriptionPage.descriptionDialog.confirm", dialogName);
    }

    public WebElement getDescriptionDialogCancel(String dialogName) {
        return getElementByDynamicArgs(getCurrentPanel(), "internalDataDescriptionPage.descriptionDialog.cancel", dialogName);
    }

    public List<WebElement> getDescriptionRow () {
        return getElements(getCurrentPanel(), "internalDataDescriptionPage.descriptionRow");
    }

    public WebElement getDescriptionEditButton (WebElement currentRow) {
        return getElement(currentRow, "internalDataDescriptionPage.descriptionEditButton");
    }

    public WebElement getDescriptionDeleteButton (WebElement currentRow) {
        return getElement(currentRow, "internalDataDescriptionPage.descriptionDeleteButton");
    }

    public WebElement getConfirmDialogButton () {
        return getElement("internalDataDescriptionPage.descriptionDeleteButtonConfirm");
    }

    public List<WebElement> getDescriptionTableRow (WebElement currentTable) {
        return getElements(currentTable,"internalDataDescriptionPage.descriptionTableRow");

    }

    public List<WebElement> getDescriptionTableCol (WebElement currentRow) {
        return getElements(currentRow, "internalDataDescriptionPage.descriptionTableCol");
    }


}
