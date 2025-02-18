package org.example.repository;

import org.example.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AssetRepository {

    public List<String> getAssets() {
        List<String> assets = new ArrayList<>();
        String query = "SELECT name FROM assets";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                assets.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return assets;
    }
}
