PGDMP         1                 {            ticketstation    13.8    13.8     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    18857    ticketstation    DATABASE     j   CREATE DATABASE ticketstation WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE ticketstation;
                postgres    false            �            1259    20468    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    20439 	   passenger    TABLE       CREATE TABLE public.passenger (
    id integer NOT NULL,
    email character varying(255),
    gender_type character varying(255),
    name character varying(255),
    phone_number character varying(255),
    surname character varying(255),
    ticket_id integer NOT NULL
);
    DROP TABLE public.passenger;
       public         heap    postgres    false            �            1259    20490    payment    TABLE     �   CREATE TABLE public.payment (
    id integer NOT NULL,
    account_number character varying(255),
    balance double precision,
    card_number character varying(255),
    cvv character varying(255),
    user_id integer
);
    DROP TABLE public.payment;
       public         heap    postgres    false            �            1259    20447    ticket    TABLE     y   CREATE TABLE public.ticket (
    id integer NOT NULL,
    transport_id integer NOT NULL,
    user_id integer NOT NULL
);
    DROP TABLE public.ticket;
       public         heap    postgres    false            �            1259    20452 	   transport    TABLE     �  CREATE TABLE public.transport (
    id integer NOT NULL,
    company character varying(255),
    passenger integer,
    depart_date character varying(255),
    departure character varying(255),
    destination character varying(255),
    pnr_no integer,
    price double precision,
    seat_no integer,
    status character varying(255),
    transport character varying(255),
    user_id integer NOT NULL
);
    DROP TABLE public.transport;
       public         heap    postgres    false            �            1259    20460    users    TABLE     {  CREATE TABLE public.users (
    id integer NOT NULL,
    birthday character varying(255),
    email character varying(255),
    gender character varying(255),
    id_number character varying(255),
    name character varying(255),
    password character varying(255),
    phone_number character varying(255),
    surname character varying(255),
    type character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    20439 	   passenger 
   TABLE DATA           c   COPY public.passenger (id, email, gender_type, name, phone_number, surname, ticket_id) FROM stdin;
    public          postgres    false    200   �       �          0    20490    payment 
   TABLE DATA           Y   COPY public.payment (id, account_number, balance, card_number, cvv, user_id) FROM stdin;
    public          postgres    false    205   a       �          0    20447    ticket 
   TABLE DATA           ;   COPY public.ticket (id, transport_id, user_id) FROM stdin;
    public          postgres    false    201   �       �          0    20452 	   transport 
   TABLE DATA           �   COPY public.transport (id, company, passenger, depart_date, departure, destination, pnr_no, price, seat_no, status, transport, user_id) FROM stdin;
    public          postgres    false    202   �       �          0    20460    users 
   TABLE DATA           t   COPY public.users (id, birthday, email, gender, id_number, name, password, phone_number, surname, type) FROM stdin;
    public          postgres    false    203   �        �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 21, true);
          public          postgres    false    204            7           2606    20446    passenger passenger_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.passenger
    ADD CONSTRAINT passenger_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.passenger DROP CONSTRAINT passenger_pkey;
       public            postgres    false    200            ?           2606    20497    payment payment_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.payment DROP CONSTRAINT payment_pkey;
       public            postgres    false    205            9           2606    20451    ticket ticket_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_pkey;
       public            postgres    false    201            ;           2606    20459    transport transport_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.transport DROP CONSTRAINT transport_pkey;
       public            postgres    false    202            =           2606    20467    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    203            C           2606    20485 %   transport fkihbq2j4f7hik1gp6fb98ekspv    FK CONSTRAINT     �   ALTER TABLE ONLY public.transport
    ADD CONSTRAINT fkihbq2j4f7hik1gp6fb98ekspv FOREIGN KEY (user_id) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.transport DROP CONSTRAINT fkihbq2j4f7hik1gp6fb98ekspv;
       public          postgres    false    2877    202    203            A           2606    20475 "   ticket fklpqg9q1elewlklsahm5ockgwj    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT fklpqg9q1elewlklsahm5ockgwj FOREIGN KEY (transport_id) REFERENCES public.transport(id);
 L   ALTER TABLE ONLY public.ticket DROP CONSTRAINT fklpqg9q1elewlklsahm5ockgwj;
       public          postgres    false    202    201    2875            B           2606    20480 "   ticket fkmvugyjf7b45u0juyue7k3pct0    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT fkmvugyjf7b45u0juyue7k3pct0 FOREIGN KEY (user_id) REFERENCES public.users(id);
 L   ALTER TABLE ONLY public.ticket DROP CONSTRAINT fkmvugyjf7b45u0juyue7k3pct0;
       public          postgres    false    2877    203    201            @           2606    20470 %   passenger fkos3sguiasei5a6ysi44ovwou2    FK CONSTRAINT     �   ALTER TABLE ONLY public.passenger
    ADD CONSTRAINT fkos3sguiasei5a6ysi44ovwou2 FOREIGN KEY (ticket_id) REFERENCES public.ticket(id);
 O   ALTER TABLE ONLY public.passenger DROP CONSTRAINT fkos3sguiasei5a6ysi44ovwou2;
       public          postgres    false    201    200    2873            �   �   x�e�=
�0 ����_��l
����%ʣ:驜���4�����$��r�!��t˰���΃/
A�m�6�}�GN@I���穛��2�(k�))��/��}��HrZY������s<��:�	�h��F؆G"� ��9�      �   9   x�%��  �j{�8��.�?�p%��X;��k0y�*��!�|�u�^e�#��H^}�      �   '   x�34�4�4�24�4�4�24��4�2� R�\1z\\\ Lb\      �   �   x���<���$1/�4G�1�('3/��Ӏ����X��L��!dU�f�8M�،��9�3̕3���ϕӐ�� ��$]c�~Ǽ�ĢD��!�%�(cqct����r��@�,�M��U)-�4D8��C��af8�M0���dW@=c�	P�1�v���`�7`��f�!1$F��� b"x�      �   d  x�}���GD�Y��,O�HX��@���:�8K`�����ǔ�"!ʠ��NW/"

��wU�*���������x+��//�X�Y,�c��-����80hh�ⴶ���T�������b���jQlG���V�Tݻ��s!B�!*��=*Mӕ:+/�UKEȗTL�H:߿zx}�&I�]�����n���t�/q��)K M�%�ۥM�)B}4�A�f�:� �{�a[��nS���#�{�
QBp�J4¸V�B�SGl���8�h����O��Syx}�������':���#�u{Z�H[��y�������V�
�=}��Cg4�Y�3,i���{&���Bo����[ԗe���Q�۪�=��5r�
���5��.���x��-�47y�tTև'�����%'J��mp]�~��kC���F�x�1����nP���B���4#�:�b.a'�M�$�)(�[P��:���ِ��^I���e�器Y���\�������/oޞ��$y G�<h��;Zt9V�|�I�`ҡcC˞��'�-�NՄaT&GY:l�ٔA�!��'�-��؜w3��{��d߄��z����C�-�Z���|q:���o�     