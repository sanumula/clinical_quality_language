package org.opencds.cqf.cql.engine.execution;

import java.util.List;
import org.opencds.cqf.cql.engine.elm.executing.EquivalentEvaluator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Issue208 extends CqlTestBase {

    @Test
    public void testInterval() {
        var results = engine.evaluate(toElmIdentifier("Issue208"));
        var value = results.forExpression("Let Test 1").value();
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(0), 1));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(1), 2));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(2), 3));

        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(0), 4));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(1), 5));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(2), 6));

        value = results.forExpression("Let Test 2").value();
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(0), 1));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(1), 2));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(0))).get(2), 3));

        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(0), 4));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(1), 5));
        Assert.assertTrue(EquivalentEvaluator.equivalent(((List<?>) (((List<?>) value).get(1))).get(2), 6));
    }
}
