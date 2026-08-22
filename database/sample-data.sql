-- Insert default roles
INSERT INTO roles (name, description) VALUES
                                          ('ROLE_USER', 'Standard user with basic banking operations'),
                                          ('ROLE_ADMIN', 'Administrator with full system access');

-- Insert admin user (password: admin123 - BCrypt encoded)
INSERT INTO users (username, password, email, full_name, enabled) VALUES
    ('admin', '$2a$10$K7Bk5CwX9YzAbCdEfGhIjKlMnOpQrStUvWxYz0123456789ABCDEF', 'admin@bank.com', 'System Administrator', TRUE);

-- Assign admin role to admin user
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);

-- Insert sample user (password: user123)
INSERT INTO users (username, password, email, full_name, phone, enabled) VALUES
    ('john.doe', '$2a$10$XyZ9AbCdEfGhIjKlMnOpQrStUvWxYz0123456789ABCDEFGHIJ', 'john.doe@email.com', 'John Doe', '9876543210', TRUE);

-- Assign user role to sample user
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);

-- Create sample account
INSERT INTO accounts (user_id, account_number, account_type, balance, currency, status) VALUES
    (2, 'ACC202608211000001', 'SAVINGS', 5000.00, 'USD', 'ACTIVE');