package com.thinkaurelius.titan.diskstorage.hbase;

import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.List;

public class HTable1_2 implements TableMask
{
    private final Table table;

    public HTable1_2(Table table)
    {
        this.table = table;
    }

    @Override
    public ResultScanner getScanner(Scan filter) throws IOException
    {
        return table.getScanner(filter);
    }

    @Override
    public Result[] get(List<Get> gets) throws IOException
    {
        return table.get(gets);
    }

    @Override
    public void batch(List<Row> writes, Object[] results) throws IOException, InterruptedException
    {
        table.batch(writes, results);
        /* table.flushCommits(); not needed anymore */
    }

    @Override
    public void close() throws IOException
    {
        table.close();
    }
}
