-- Step 2: Create the city table
CREATE TABLE city (
    city_id SERIAL PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
    state_abbreviation VARCHAR(2) NOT NULL
);
-- Step 4: Create the zipcode table
CREATE TABLE zipcode (
    zip_code_id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city(city_id)
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
    INSERT INTO city (city_name, state_abbreviation) VALUES
    -- Alabama
    ('Birmingham', 'AL'),
    ('Montgomery', 'AL'),
    ('Mobile', 'AL'),

    -- Alaska
    ('Anchorage', 'AK'),
    ('Fairbanks', 'AK'),
    ('Juneau', 'AK'),

    -- Arizona
    ('Phoenix', 'AZ'),
    ('Tucson', 'AZ'),
    ('Mesa', 'AZ'),

    -- Arkansas
    ('Little Rock', 'AR'),
    ('Fayetteville', 'AR'),
    ('Fort Smith', 'AR'),

    -- California
    ('Los Angeles', 'CA'),
    ('San Francisco', 'CA'),
    ('San Diego', 'CA'),

    -- Colorado
    ('Denver', 'CO'),
    ('Colorado Springs', 'CO'),
    ('Aurora', 'CO'),

    -- Connecticut
    ('Hartford', 'CT'),
    ('New Haven', 'CT'),
    ('Stamford', 'CT'),

    -- Delaware
    ('Wilmington', 'DE'),
    ('Dover', 'DE'),
    ('Newark', 'DE'),

    -- Florida
    ('Miami', 'FL'),
    ('Orlando', 'FL'),
    ('Tampa', 'FL'),

    -- Georgia
    ('Atlanta', 'GA'),
    ('Savannah', 'GA'),
    ('Augusta', 'GA'),

    -- Hawaii
    ('Honolulu', 'HI'),
    ('Hilo', 'HI'),
    ('Kailua', 'HI'),

    -- Idaho
    ('Boise', 'ID'),
    ('Meridian', 'ID'),
    ('Idaho Falls', 'ID'),

    -- Illinois
    ('Chicago', 'IL'),
    ('Springfield', 'IL'),
    ('Naperville', 'IL'),

    -- Indiana
    ('Indianapolis', 'IN'),
    ('Fort Wayne', 'IN'),
    ('Evansville', 'IN'),

    -- Iowa
    ('Des Moines', 'IA'),
    ('Cedar Rapids', 'IA'),
    ('Davenport', 'IA'),

    -- Kansas
    ('Wichita', 'KS'),
    ('Overland Park', 'KS'),
    ('Kansas City', 'KS'),

    -- Kentucky
    ('Louisville', 'KY'),
    ('Lexington', 'KY'),
    ('Bowling Green', 'KY'),

    -- Louisiana
    ('New Orleans', 'LA'),
    ('Baton Rouge', 'LA'),
    ('Shreveport', 'LA'),

    -- Maine
    ('Portland', 'ME'),
    ('Lewiston', 'ME'),
    ('Bangor', 'ME'),

    -- Maryland
    ('Baltimore', 'MD'),
    ('Annapolis', 'MD'),
    ('Rockville', 'MD'),

    -- Massachusetts
    ('Boston', 'MA'),
    ('Worcester', 'MA'),
    ('Springfield', 'MA'),

    -- Michigan
    ('Detroit', 'MI'),
    ('Grand Rapids', 'MI'),
    ('Ann Arbor', 'MI'),

    -- Minnesota
    ('Minneapolis', 'MN'),
    ('Saint Paul', 'MN'),
    ('Rochester', 'MN'),

    -- Mississippi
    ('Jackson', 'MS'),
    ('Gulfport', 'MS'),
    ('Hattiesburg', 'MS'),

    -- Missouri
    ('Kansas City', 'MO'),
    ('Saint Louis', 'MO'),
    ('Springfield', 'MO'),

    -- Montana
    ('Billings', 'MT'),
    ('Missoula', 'MT'),
    ('Bozeman', 'MT'),

    -- Nebraska
    ('Omaha', 'NE'),
    ('Lincoln', 'NE'),
    ('Bellevue', 'NE'),

    -- Nevada
    ('Las Vegas', 'NV'),
    ('Reno', 'NV'),
    ('Henderson', 'NV'),

    -- New Hampshire
    ('Manchester', 'NH'),
    ('Nashua', 'NH'),
    ('Concord', 'NH'),

    -- New Jersey
    ('Newark', 'NJ'),
    ('Jersey City', 'NJ'),
    ('Paterson', 'NJ'),

    -- New Mexico
    ('Albuquerque', 'NM'),
    ('Santa Fe', 'NM'),
    ('Las Cruces', 'NM'),

    -- New York
    ('New York City', 'NY'),
    ('Buffalo', 'NY'),
    ('Rochester', 'NY'),

    -- North Carolina
    ('Charlotte', 'NC'),
    ('Raleigh', 'NC'),
    ('Greensboro', 'NC'),

    -- North Dakota
    ('Fargo', 'ND'),
    ('Bismarck', 'ND'),
    ('Grand Forks', 'ND'),

    -- Ohio
    ('Columbus', 'OH'),
    ('Cleveland', 'OH'),
    ('Cincinnati', 'OH'),

    -- Oklahoma
    ('Oklahoma City', 'OK'),
    ('Tulsa', 'OK'),
    ('Norman', 'OK'),

    -- Oregon
    ('Portland', 'OR'),
    ('Salem', 'OR'),
    ('Eugene', 'OR'),

    -- Pennsylvania
    ('Philadelphia', 'PA'),
    ('Pittsburgh', 'PA'),
    ('Allentown', 'PA'),

    -- Rhode Island
    ('Providence', 'RI'),
    ('Cranston', 'RI'),
    ('Warwick', 'RI'),

    -- South Carolina
    ('Charleston', 'SC'),
    ('Columbia', 'SC'),
    ('Greenville', 'SC'),

    -- South Dakota
    ('Sioux Falls', 'SD'),
    ('Rapid City', 'SD'),
    ('Aberdeen', 'SD'),

    -- Tennessee
    ('Nashville', 'TN'),
    ('Memphis', 'TN'),
    ('Knoxville', 'TN'),

    -- Texas
    ('Houston', 'TX'),
    ('Dallas', 'TX'),
    ('Austin', 'TX'),

    -- Utah
    ('Salt Lake City', 'UT'),
    ('Provo', 'UT'),
    ('Ogden', 'UT'),

    -- Vermont
    ('Burlington', 'VT'),
    ('Montpelier', 'VT'),
    ('Rutland', 'VT'),

    -- Virginia
    ('Virginia Beach', 'VA'),
    ('Norfolk', 'VA'),
    ('Richmond', 'VA'),

    -- Washington
    ('Seattle', 'WA'),
    ('Spokane', 'WA'),
    ('Tacoma', 'WA'),

    -- West Virginia
    ('Charleston', 'WV'),
    ('Huntington', 'WV'),
    ('Morgantown', 'WV'),

    -- Wisconsin
    ('Milwaukee', 'WI'),
    ('Madison', 'WI'),
    ('Green Bay', 'WI'),

    -- Wyoming
    ('Cheyenne', 'WY'),
    ('Casper', 'WY'),
    ('Laramie', 'WY');