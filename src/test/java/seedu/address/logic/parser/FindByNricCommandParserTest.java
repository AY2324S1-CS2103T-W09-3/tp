package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindByNricCommand;
import seedu.address.model.person.Nric;
import seedu.address.model.person.NricContainsKeywordPredicate;

public class FindByNricCommandParserTest {
    private FindByNricCommandParser parser = new FindByNricCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByNricCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces, test that trimming worked
        FindByNricCommand expectedFindByNricCommand =
                new FindByNricCommand(new NricContainsKeywordPredicate("S1234567N"));
        assertParseSuccess(parser, " S1234567N ", expectedFindByNricCommand);
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        //not starting with S/T
        assertParseFailure(parser, " A1234567N ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, Nric.MESSAGE_CONSTRAINTS));
        // only numbers
        assertParseFailure(parser, " 1234567 ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, Nric.MESSAGE_CONSTRAINTS));
        //invalid format
        assertParseFailure(parser, " S12345N67 ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, Nric.MESSAGE_CONSTRAINTS));
    }
}
