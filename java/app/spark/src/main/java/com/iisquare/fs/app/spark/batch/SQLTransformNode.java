package com.iisquare.fs.app.spark.batch;

import com.iisquare.fs.app.spark.core.SparkRunner;
import com.iisquare.fs.base.core.util.DPUtil;
import com.iisquare.fs.base.dag.core.DAGNode;
import com.iisquare.fs.base.dag.transform.AbstractConvertTransform;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SQLContext;

public class SQLTransformNode extends AbstractConvertTransform {
    @Override
    public Object process() throws Exception {
        SQLContext context = runner(SparkRunner.class).session().sqlContext();
        for (DAGNode source : sources) {
            String alias = source.alias();
            if (DPUtil.empty(alias)) alias = source.getId();
            source.result(Dataset.class).createTempView(alias);
        }
        return context.sql(options.at("/sql").asText());
    }

}
