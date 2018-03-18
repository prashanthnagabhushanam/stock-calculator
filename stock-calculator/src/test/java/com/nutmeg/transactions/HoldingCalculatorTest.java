package com.nutmeg.transactions;

import static com.nutmeg.transactions.util.FileUtils.fileFromResources;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.nutmeg.transactions.Holding;
import com.nutmeg.transactions.HoldingCalculator;
import com.nutmeg.transactions.HoldingCalculatorImpl;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;


public class HoldingCalculatorTest {

  private HoldingCalculator holdingCalculator;

  @Before
  public void setUp(){
    holdingCalculator = new HoldingCalculatorImpl();
  }

  @Test
  public void withNEAB0001() throws IOException {
    String fileName = "all.csv";

    Map<String,List<Holding>> holdings = holdingCalculator.calculateHoldings(fileFromResources(fileName), LocalDate.parse("20161201",BASIC_ISO_DATE));

    assertThat(holdings)
        .isNotEmpty()
        .containsOnlyKeys("NEAB0001") ;

  }

  @Test
  public void withNEAA0000() throws IOException {
    String fileName = "all.csv";

    Map<String,List<Holding>> holdings = holdingCalculator.calculateHoldings(fileFromResources(fileName), LocalDate.parse("20170201",BASIC_ISO_DATE));

    assertThat(holdings)
        .isNotEmpty()
        .containsOnlyKeys("NEAA0000") ;

  }
}