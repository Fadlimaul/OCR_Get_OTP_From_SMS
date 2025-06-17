import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.regex.Pattern as Pattern
import java.util.regex.Matcher as Matcher

Mobile.startApplication('C:\\Users\\yozar\\Downloads\\AndroidMessages.apk', true)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - BERIKUTNYA'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - Message'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - Jadikan default'), 0)

Mobile.tap(findTestObject('OR message/android.widget.TextView - TWILIO'), 0)

//String message = Mobile.getText(findTestObject('null'), 
//    0)
//
//print(message)
Mobile.delay(5)

// Ambil teks dari elemen pesan
String message = Mobile.getText(findTestObject('OR message/android.widget.TextView - Kode verifikasi Twilio anda adalah 765735'), 
    0)


// Regex untuk menangkap angka OTP
Pattern p1 = Pattern.compile('.*?(\\d{6})')

Matcher m1 = p1.matcher(message)

if (m1.find()) {
    String otp = m1.group(1 // Ambil angka OTP
        )

    println('Kode Verifikasi (OTP): ' + otp // Output ke console
        )
} else {
    println('OTP tidak ditemukan!')
}

Mobile.delay(5)

Mobile.closeApplication()

