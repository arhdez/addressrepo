-- Step 2: Create the city table
CREATE TABLE city (
    city_id SERIAL PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
    state_abbreviation CHAR(2) NOT NULL
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
    zip_code_id INT NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city(city_id),
    FOREIGN KEY (zip_code_id) REFERENCES zipcode(zip_code_id)
);

    -- Inserting cities into the 'city' table
    INSERT INTO city (city_name, state_abbreviation) VALUES ('New York', 'NY');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Los Angeles', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Chicago', 'IL');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Houston', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Phoenix', 'AZ');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Philadelphia', 'PA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('San Antonio', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('San Diego', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Dallas', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('San Jose', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Austin', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Jacksonville', 'FL');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Fort Worth', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Columbus', 'OH');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Charlotte', 'NC');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('San Francisco', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Indianapolis', 'IN');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Seattle', 'WA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Denver', 'CO');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Washington', 'DC');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Boston', 'MA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('El Paso', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Nashville', 'TN');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Detroit', 'MI');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Oklahoma City', 'OK');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Portland', 'OR');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Las Vegas', 'NV');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Memphis', 'TN');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Louisville', 'KY');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Baltimore', 'MD');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Milwaukee', 'WI');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Albuquerque', 'NM');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Tucson', 'AZ');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Fresno', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Sacramento', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Mesa', 'AZ');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Kansas City', 'MO');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Atlanta', 'GA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Omaha', 'NE');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Raleigh', 'NC');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Miami', 'FL');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Long Beach', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Virginia Beach', 'VA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Oakland', 'CA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Minneapolis', 'MN');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Tulsa', 'OK');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Arlington', 'TX');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('New Orleans', 'LA');
    INSERT INTO city (city_name, state_abbreviation) VALUES ('Wichita', 'KS');