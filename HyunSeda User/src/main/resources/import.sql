# Save the updated SQL content to a new file
updated_sql_content = """
-- Create tables
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Insert default roles
INSERT INTO roles (name) VALUES ('administrador');
INSERT INTO roles (name) VALUES ('superAdministrador');
INSERT INTO roles (name) VALUES ('usuario');

-- Other table creation statements (if any)
"""

# Save the content to a new file
file_path = "/mnt/data/import_with_roles.sql"
with open(file_path, "w") as file:
    file.write(updated_sql_content)