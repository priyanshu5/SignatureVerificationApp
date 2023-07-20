INSERT INTO userdetails (id, username, password) VALUES (1, 'USA','$2a$12$E2dU5UPPvjIiD.MXOuzlVeqRikN9TkQg3Vy528U9qJBa0xYX8LVJq');
INSERT INTO userdetails (id, username, password) VALUES (2, 'USA2','$2a$12$KcAyIyYXID4HKB7AZ8Tq5..d.LGmtymQfeTjWm6wJgIL0GuARyd/G');
INSERT INTO userdetails (id, username, password) VALUES (3, 'USA3','$2a$12$HXD2Th97gb3IRblfd4dNIudBnk5gKY3C5tzheIYjTKaRuFuVPIvWy');
INSERT INTO event_source (
  business_key,
  application,
  comments,
  transaction_currency,
  transaction_amount,
  amount_in_mur,
  debit_account_number,
  account_short_name,
  debit_account_ccy,
  payment_details_1,
  payment_details_2,
  payment_details_3,
  payment_details_4,
  discrepancy_reason,
  created_by,
  created_on,
  updated_by,
  updated_on,
  priority,
  source_bu,
  document_capture_reference,
  status
)
VALUES
  ('business_key1', 'application1', 'comments1', 'USD', 100, 500, 'debit_account_number1', 'account_short_name1', 'USD', 'payment_details_1', 'payment_details_2', 'payment_details_3', 'payment_details_4', 'discrepancy_reason1', 'created_by1', CURRENT_TIMESTAMP, 'updated_by1', CURRENT_TIMESTAMP, 'Normal', 'source_bu1', '/assets/pdfs/dummy1.pdf', 'unassigned'),
  ('business_key2', 'application2', 'comments2', 'EUR', 200, 800, 'debit_account_number2', 'account_short_name2', 'EUR', 'payment_details_1', 'payment_details_2', 'payment_details_3', 'payment_details_4', 'discrepancy_reason2', 'created_by2', CURRENT_TIMESTAMP, 'updated_by2', CURRENT_TIMESTAMP, 'Fast Track', 'source_bu2', '/assets/pdfs/dummy2.pdf', 'Proceed'),
  ('business_key3', 'application3', 'comments3', 'GBP', 300, 1200, 'debit_account_number3', 'account_short_name3', 'GBP', 'payment_details_1', 'payment_details_2', 'payment_details_3', 'payment_details_4', 'discrepancy_reason3', 'created_by3', CURRENT_TIMESTAMP, 'updated_by3', CURRENT_TIMESTAMP, 'Normal', 'source_bu3', '/assets/pdfs/dummy3.pdf', 'Reject');
