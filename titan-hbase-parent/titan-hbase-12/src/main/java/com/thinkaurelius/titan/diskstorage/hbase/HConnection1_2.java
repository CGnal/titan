package com.thinkaurelius.titan.diskstorage.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

public class HConnection1_2 implements ConnectionMask
{

    private final Connection cnx;

    public HConnection1_2(Connection cnx)
    {
        this.cnx = cnx;
    }

    @Override
    public TableMask getTable(String name) throws IOException
    {
        return new HTable1_2(cnx.getTable(TableName.valueOf(name)));
    }

    @Override
    public AdminMask getAdmin() throws IOException
    {
        return new HBaseAdmin1_2(new HBaseAdmin(cnx));
    }

    @Override
    public void close() throws IOException
    {
        cnx.close();
    }
}
