-- Step 2: Create the city table
CREATE TABLE city (
    city_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    state_id INT NOT NULL
);

-- Step 3: Create the state table
CREATE TABLE state (
    state_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    abbreviation CHAR(2) NOT NULL
);

-- Step 4: Create the zipcode table
CREATE TABLE zipcode (
    zip_code_id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL
);

-- Step 5: Create the address table
CREATE TABLE address (
    --address_id SERIAL PRIMARY KEY,
    address_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    street VARCHAR(255) NOT NULL,
    city_id INT NOT NULL,
    state_id INT NOT NULL,
    zip_code_id INT NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city(city_id),
    FOREIGN KEY (state_id) REFERENCES state(state_id),
    FOREIGN KEY (zip_code_id) REFERENCES zipcode(zip_code_id)
);

-- Step 6: Add constraints and relationships between tables
ALTER TABLE city ADD CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES state(state_id);

-- Insert states with id, name, and abbreviation
INSERT INTO state (name, abbreviation)
VALUES
    ('Alabama', 'AL'),
    ('Alaska', 'AK'),
    ('Arizona', 'AZ'),
    ('Arkansas', 'AR'),
    ('California', 'CA'),
    ('Colorado', 'CO'),
    ('Connecticut', 'CT'),
    ('Delaware', 'DE'),
    ('Florida', 'FL'),
    ('Georgia', 'GA'),
    ('Hawaii', 'HI'),
    ('Idaho', 'ID'),
    ('Illinois', 'IL'),
    ('Indiana', 'IN'),
    ('Iowa', 'IA'),
    ('Kansas', 'KS'),
    ('Kentucky', 'KY'),
    ('Louisiana', 'LA'),
    ('Maine', 'ME'),
    ('Maryland', 'MD'),
    ('Massachusetts', 'MA'),
    ('Michigan', 'MI'),
    ('Minnesota', 'MN'),
    ('Mississippi', 'MS'),
    ('Missouri', 'MO'),
    ('Montana', 'MT'),
    ('Nebraska', 'NE'),
    ('Nevada', 'NV'),
    ('New Hampshire', 'NH'),
    ('New Jersey', 'NJ'),
    ('New Mexico', 'NM'),
    ('New York', 'NY'),
    ('North Carolina', 'NC'),
    ('North Dakota', 'ND'),
    ('Ohio', 'OH'),
    ('Oklahoma', 'OK'),
    ('Oregon', 'OR'),
    ('Pennsylvania', 'PA'),
    ('Rhode Island', 'RI'),
    ('South Carolina', 'SC'),
    ('South Dakota', 'SD'),
    ('Tennessee', 'TN'),
    ('Texas', 'TX'),
    ('Utah', 'UT'),
    ('Vermont', 'VT'),
    ('Virginia', 'VA'),
    ('Washington', 'WA'),
    ('West Virginia', 'WV'),
    ('Wisconsin', 'WI'),
    ('Wyoming', 'WY');

    -- Insert cities with names and corresponding state_id values
    INSERT INTO city (name, state_id)
    VALUES
        ('New York City', (SELECT state_id FROM state WHERE abbreviation = 'NY')),
        ('Los Angeles', (SELECT state_id FROM state WHERE abbreviation = 'CA')),
        ('Chicago', (SELECT state_id FROM state WHERE abbreviation = 'IL')),
        ('Houston', (SELECT state_id FROM state WHERE abbreviation = 'TX')),
        ('Phoenix', (SELECT state_id FROM state WHERE abbreviation = 'AZ')),
        ('Philadelphia', (SELECT state_id FROM state WHERE abbreviation = 'PA')),
        ('San Antonio', (SELECT state_id FROM state WHERE abbreviation = 'TX')),
        ('San Diego', (SELECT state_id FROM state WHERE abbreviation = 'CA')),
        ('Dallas', (SELECT state_id FROM state WHERE abbreviation = 'TX')),
        ('San Jose', (SELECT state_id FROM state WHERE abbreviation = 'CA')),
        ('Austin', (SELECT state_id FROM state WHERE abbreviation = 'TX')),
        ('Jacksonville', (SELECT state_id FROM state WHERE abbreviation = 'FL')),
        ('Fort Worth', (SELECT state_id FROM state WHERE abbreviation = 'TX')),
        ('Columbus', (SELECT state_id FROM state WHERE abbreviation = 'OH')),
        ('Charlotte', (SELECT state_id FROM state WHERE abbreviation = 'NC')),
        ('San Francisco', (SELECT state_id FROM state WHERE abbreviation = 'CA')),
        ('Indianapolis', (SELECT state_id FROM state WHERE abbreviation = 'IN')),
        ('Seattle', (SELECT state_id FROM state WHERE abbreviation = 'WA')),
        ('Denver', (SELECT state_id FROM state WHERE abbreviation = 'CO'))