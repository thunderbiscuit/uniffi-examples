uniffi::include_scaffolding!("clock");

#[derive(Debug)]
pub enum ClockType {
    Digital,
    Analog,
}

#[derive(Debug)]
pub enum OtherTypeNotUseful {
    Maybe,
    MaybeNot,
}
