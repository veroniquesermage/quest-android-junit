package fr.wildcodeschool.emailbuilder;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class EmailBuilderTest {

  // --------------------------------------------------------------------------
  // TEST : EmailBuilder.Builder class
  // --------------------------------------------------------------------------

  @Test
  public void emailBuilder_GetEmailSimple_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setTld("com")
      .build();
    assertEquals("name@email.com", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailWithSubDomain_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("name@email.co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoUsername_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setDomain("email")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("@email.co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoDomain_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("name@co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoTld_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setSubDomain("co")
      .build();
    assertEquals("name@email.co", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailEmptyString_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("")
      .setDomain("")
      .setSubDomain("")
      .setTld("")
      .build();
    assertEquals("", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetNullEmail_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder.Builder().build();
    assertEquals("", emailBuilder.getEmail());
  }

  // --------------------------------------------------------------------------
  // TEST : isValidEmail method
  // --------------------------------------------------------------------------

  @Test
  public void emailBuilder_isValidEmailSimple_ReturnsTrue() {

    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setTld("com")
            .build();

    assertTrue(EmailBuilder.isValidEmail(emailBuilder.getEmail()));

  }

  @Test
  public void emailBuilder_isValidEmailWithSubDomain_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setSubDomain("uk")
            .setTld("com")
            .build();

      assertTrue(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoUsername_ReturnsFalse() {
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("")
            .setDomain("email")
            .setTld("com")
            .build();

    assertFalse( EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoDomain_ReturnsFalse() {
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("name")
              .setDomain("")
              .setTld("com")
              .build();

      assertFalse( EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoTld_ReturnsFalse() {
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("name")
              .setDomain("email")
              .setTld("")
              .build();

      assertFalse( EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailEmptyString_ReturnsFalse() {
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("")
              .setDomain("")
              .setTld("")
              .build();

      assertFalse( EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidNullEmail_ReturnsFalse() {
    EmailBuilder emailBuilder = new EmailBuilder.Builder().build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  // Add test here

  // * Check name validity (*$£%ù^¨&é"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“)

    @Test
    public void emailBuilder_nameIsValid_ReturnsFalse(){
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
              .setDomain("email")
              .setTld("com")
              .build();

      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }

    // * Check name length
    @Test
    public void emailBuilder_isValidNameLength_ReturnsFalse(){
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName(String.join("", Collections.nCopies(257,"a")))
              .setDomain("email")
              .setTld("com")
              .build();

      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }

  // * Check domain validity
    @Test
    public void emailBuilder_isValidDomain_ReturnsFalse(){
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setDomain("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
                .setTld("com")
                .build();

        assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));

    }

  // * Check domain length
    @Test
    public void emailBuilder_isValidDomainLentgh_ReturnsFalse(){

      EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain(String.join("", Collections.nCopies(66,"a")))
            .setTld("com")
            .build();

      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }


  // * Check sub domain validity

    @Test
    public void emailBuilder_isValidSubDomain_ReturnsFalse(){
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setDomain("email")
                .setSubDomain("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
                .setTld("com")
                .build();
        assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }
  // * Check sub domain length

    @Test
    public void emailBuilder_isValidSubDomainLength_ReturnsFalse(){
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("name")
              .setDomain("email")
              .setSubDomain(String.join("",Collections.nCopies(27,"a")))
              .setTld("com")
              .build();
      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }


  // * Check tld validity
    @Test
    public void emailBuilder_isValidTld_ReturnsFalse(){
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("name")
              .setDomain("email")
              .setTld("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
              .build();
      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
    }

  // * Check tld length
  @Test
  public void emailBuilder_isValidTldLength_ReturnsFalse(){
      EmailBuilder emailBuilder = new EmailBuilder
              .Builder()
              .setUserName("name")
              .setDomain("email")
              .setTld(String.join("",Collections.nCopies(27,"a")))
              .build();
      assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }
}