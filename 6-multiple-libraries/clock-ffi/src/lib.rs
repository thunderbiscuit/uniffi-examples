uniffi::include_scaffolding!("clock");

pub struct Clock {
    pub id: u64,
    pub clock_type: ClockType,
}

#[derive(Debug)]
pub enum ClockType {
    Digital,
    Analog,
}
