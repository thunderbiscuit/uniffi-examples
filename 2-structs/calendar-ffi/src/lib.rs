uniffi::include_scaffolding!("calendar");

pub struct CalendarOptions {
    name: String,
    year: u32,
    private: bool,
}
