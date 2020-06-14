insert into airport(id,status,row_version, created_date, name, code, capacity, city, address) values(1,1,0,'2020-06-13','Sabiha Gökçen',  'SAW', 1500, 'İSTANBUL', 'Kurtköy');
insert into airport(id,status,row_version, created_date, name, code, capacity, city, address) values(2,1,0,'2020-06-13', 'Esenboga', 'ESB', 2500, 'ANKARA', 'Kurtköy');
insert into airway(id, status, row_version, created_date, name, logo) values (1,1,0, '2020-06-13', 'Türk Hava Yolları','image.jpg');
insert into customer(id, status, row_version, created_date, name, family_name, msisdn, email, birth_date, gender) values(1,1,0, '2020-06-13', 'Elif', 'Armagan', '05555555555', 'armaganelif@gmail.com', '1994-07-14', 'FEMALE' );
insert into route(id, status, row_version, created_date, departure_id, destination_id) values (1, 1, 0, '2020-06-13', 1, 2);
insert into flight(id, status, row_version, created_date, flight_no, flight_date, flight_time, total_seat_numbers, available_seat_numbers, price, sale_price, route_id, airway_id)
                    values(1, 1, 0, '2020-06-13', 'TK1005', '2020-07-19', '19:00', 100, 91, 100.00, 100.00, 1, 1);
insert into ticket(id, status, row_version, created_date, pnr_no, card_no, sale_price, customer_id, flight_id ) values(1, 1, 0, '2020-06-13', 'HT05Y', '441165******7654', 100.00, 1, 1);
