package com.sunmi.function;

import com.sunmi.common.action.InternalDataDescriptionAction;
import com.sunmi.common.selector.InternalDataDescriptionSelector;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/28 22:56
 */
@Component
public class InternalDataDescriptionHandle extends AbstractHandle {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InternalDataDescriptionAction internalDataDescriptionAction;

    public void createInternalDescription(
            Boolean partnerData, Boolean appData, Boolean deviceData, Boolean financeData,
            String department, String name, String mobile, String email) {
        internalDataDescriptionAction.clickNewDescriptionButton();
        sleep(1);
        String dialogName = "新增订阅";
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName, "合作伙伴数据", partnerData);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName, "应用数据", appData);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName, "设备数据", deviceData);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName, "金融交易数据", financeData);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName, "部门", department);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName, "姓名", name);
        internalDataDescriptionAction.scrollInternalDataDescriptionDialog(dialogName, "手机");
        sleep(1);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName, "手机", mobile);
        internalDataDescriptionAction.scrollInternalDataDescriptionDialog(dialogName, "邮箱");
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName, "邮箱", email);
        sleep(1);
        internalDataDescriptionAction.clickKeyNewDescriptionDialogConfirm(dialogName);
        Assert.assertTrue(internalDataDescriptionAction.existsDescriptionTableRow(partnerData, appData, deviceData, financeData, department, name, mobile, email));
    }

    public void editLastDescriptionRow(
            Boolean partnerData, Boolean appData, Boolean deviceData, Boolean financeData,
            String department, String name, String mobile, String email) {
        WebElement lastDescriptionRow = internalDataDescriptionAction.getLastDescriptionRow();
        sleep(1);
        internalDataDescriptionAction.clickDescriptionEditButton(lastDescriptionRow);
        sleep(3);
        String dialogName = "编辑订阅";
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName,"合作伙伴数据", partnerData);
        sleep(1);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName,"应用数据", appData);
        sleep(1);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName,"设备数据", deviceData);
        sleep(1);
        internalDataDescriptionAction.checkNewDescriptionDialogCheckBox(dialogName,"金融交易数据", financeData);
        sleep(1);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName,"部门", department);
        sleep(1);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName,"姓名", name);
        sleep(1);
        internalDataDescriptionAction.scrollInternalDataDescriptionDialog(dialogName,"手机");
        sleep(1);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName,"手机", mobile);
        sleep(1);
        internalDataDescriptionAction.scrollInternalDataDescriptionDialog(dialogName,"邮箱");
        sleep(1);
        internalDataDescriptionAction.sendKeyNewDescriptionDialogInputText(dialogName,"邮箱", email);
        sleep(1);
        internalDataDescriptionAction.clickKeyNewDescriptionDialogConfirm(dialogName);
    }

    public void deleteLastDescriptionRow() {
        WebElement lastDescriptionRow = internalDataDescriptionAction.getLastDescriptionRow();
        sleep(1);
        internalDataDescriptionAction.clickDescriptionDeleteButton(lastDescriptionRow);
        sleep(1);
        internalDataDescriptionAction.clickConfirmDialogButton();
    }
}
