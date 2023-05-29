use clock_ffi::ClockType;

uniffi::include_scaffolding!("calendar");

struct Calendar {
    id: i32,
    clock_type: ClockType,
}

impl Calendar {
    fn new(id: i32, clock_type: ClockType) -> Self {
        Calendar {
            id,
            clock_type,
        }
    }

    fn get_info(&self) -> String {
        format!("Your calendar has id {} and a clock that is {:?}", self.id, self.clock_type)
    }

    fn add(&self, a: i32, b: i32) -> i32 {
        a + b
    }
}
