package com.galaxy.merchant;

import com.galaxy.merchant.calculate.RomanCalculate;
import com.galaxy.merchant.calculate.RomanCalculateFactory;
import com.galaxy.merchant.porcessor.CreditsProcessor;
import com.galaxy.merchant.porcessor.InputProcessor;
import com.galaxy.merchant.porcessor.NumberProcessor;
import com.galaxy.merchant.porcessor.OutputResults;
import com.galaxy.merchant.porcessor.ProcessorFactorty;
import com.galaxy.merchant.porcessor.QueryProcessor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author lisanchuan
 * @date 2019-03-15
 */
public class TestMainApplication {

    private MerchantGuideMainApplication application;
    private RomanCalculate romanCalculate;
    private ProcessorFactorty processorFactorty;
    private InputProcessor inputProcessor;
    private QueryProcessor queryProcessor;


    @Before
    public void setUp() {
        application = new MerchantGuideMainApplication();
        romanCalculate = RomanCalculateFactory.INSTANCE.geRomanCalculate();
        processorFactorty = new ProcessorFactorty();
        queryProcessor = new QueryProcessor();
    }

    @Test
    public void testprocessInputs() {
        String[] inputStream = FileUtil.loadFile("input.txt").split("\n");
        String[] outputStream = FileUtil.loadFile("output.txt").split("\n");
        queryProcessor.clearQueryList();
        String[] output = application.processInputs(inputStream);
        assertThat(output, is(outputStream));
    }

    @Test
    public void testRomanCalculate() {
        assertThat(romanCalculate.calculate("MCMXCIX"), is(1999));
        assertThat(romanCalculate.calculate("MCMIII"), is(1903));
        assertThat(romanCalculate.calculate("XXXIX"), is(39));
    }

    @Test
    public void test_romanCalculate_error() {
        assertThat(romanCalculate.calculate("MMMM"), is(-1));
        assertThat(romanCalculate.calculate("MIVIL"), is(-1));
        assertThat(romanCalculate.calculate("MLC"), is(-1));
    }

    @Test
    public void test_input_number_processor() {
        String input = "xuy is D";
        processorFactorty.inputProcessor(input);
        inputProcessor = new NumberProcessor();
        assertThat(inputProcessor.getStorageMap().get("xuy"), is("D"));
    }

    @Test
    public void test_input_credits_processor() {
        processorFactorty.inputProcessor("xuy is D");
        processorFactorty.inputProcessor("xuy Silver is 34 Credits");

        inputProcessor = new CreditsProcessor();
        assertThat(inputProcessor.getStorageMap().get("Silver"), is(0.068));
    }

    @Test
    public void test_output_credits_value_processor() {
        processorFactorty.inputProcessor("xuy is I");
        processorFactorty.inputProcessor("cvb is V");
        processorFactorty.inputProcessor("xuy cvb Silver is 34 Credits");

        processorFactorty.outputProcessor("how many Credits is cvb xuy Silver ?");
        inputProcessor = new CreditsProcessor();
        OutputResults outputResults = new OutputResults();
        assertThat(inputProcessor.getStorageMap().get("Silver"), is(8.5));
        assertThat(outputResults.toConvertOutput()[0], is("cvb xuy Silver is 51 Credits"));
        outputResults.clearOutput();
    }

}
