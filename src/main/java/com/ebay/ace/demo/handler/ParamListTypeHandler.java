package com.ebay.ace.demo.handler;

import com.ebay.ace.demo.entiry.Param;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ParamListTypeHandler extends BaseTypeHandler<List<Param>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Param> parameter, JdbcType jdbcType) throws SQLException {
        try {
            // Serialize the list of Param objects to a JSON string
            String json = objectMapper.writeValueAsString(parameter);
            ps.setString(i, json);
        } catch (JsonProcessingException e) {
            throw new SQLException("Error converting parameter list to JSON string", e);
        }
    }

    @Override
    public List<Param> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);
        return parseJson(json);
    }

    @Override
    public List<Param> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);
        return parseJson(json);
    }

    @Override
    public List<Param> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);
        return parseJson(json);
    }

    private List<Param> parseJson(String json) throws SQLException {
        System.out.println("Parsing JSON string: " + json);
        try {
            if (json != null && !json.isEmpty()) {
                // Deserialize the JSON string to a list of Param objects
                return objectMapper.readValue(json, new TypeReference<List<Param>>() {});
            }
            return null;
        } catch (JsonProcessingException e) {
            throw new SQLException("Error parsing JSON string to parameter list", e);
        }
    }
}